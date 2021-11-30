<template>
  <tr class="address-list_tr">
    <td>
      <div class="check-box_wrap">
        <img v-if="addressObj.selected" :src="imgPathSingleY" alt="checked" />
        <svg
          v-else
          @click="onClickCheckBoxBtn(addressObj.idx)"
          width="30"
          height="30"
          viewBox="0 0 30 30"
          fill="none"
          xmlns="http://www.w3.org/2000/svg"
        >
          <circle
            cx="15"
            cy="15"
            r="14"
            fill="white"
            stroke="#BBBBBB"
            stroke-width="2"
          />
        </svg>
      </div>
    </td>
    <td class="address_name" :class="{ selected: addressObj.selected }">
      {{ addressObj.name }}
    </td>
    <td class="address_td">
      <div class="address_main" :class="{ selected: addressObj.selected }">
        {{ addressObj.addressMain }}
      </div>
      <div
        v-if="!addressObj.changeMode"
        class="address_detail"
        :class="{ selected: addressObj.selected }"
      >
        {{ addressObj.addressDetail }}
      </div>
      <div class="edit_address_detail" v-else>
        <input
          type="text"
          v-model="input"
          @keyup.enter="onClickConfirmBtn(addressObj.idx)"
          @keyup.esc="onClickCancelBtn(addressObj.idx)"
        />
        <div
          class="address-config_modal_btn confirm"
          @click="onClickConfirmBtn(addressObj.idx)"
        >
          확인
        </div>
        <div
          class="address-config_modal_btn cancel"
          @click="onClickCancelBtn(addressObj.idx)"
        >
          취소
        </div>
      </div>
    </td>
    <td>
      <div
        class="address-config_modal_btn edit"
        :class="{ 'on-change-mode': addressObj.changeMode }"
        @click="onClickEditBtn(addressObj.idx)"
      >
        상세 주소 편집
      </div>
    </td>
    <td class="close_td">
      <div class="icon_close_wrap">
        <svg
          width="20"
          height="20"
          viewBox="0 0 20 20"
          fill="#999999"
          xmlns="http://www.w3.org/2000/svg"
        >
          <path
            d="M20 2.01429L17.9857 0L10 7.98571L2.01429 0L0 2.01429L7.98571 10L0 17.9857L2.01429 20L10 12.0143L17.9857 20L20 17.9857L12.0143 10L20 2.01429Z"
          />
        </svg>
      </div>
    </td>
  </tr>
  <hr />
</template>

<script>
import { mapActions, mapState } from "vuex";
import { SET_ADDRESS_DETAIL, SET_CHANGE_MODE } from "@/store/modules/member.js";

export default {
  props: ["addressObj"],
  emits: ["open-modal"],
  data() {
    return {
      input: this.addressObj.addressDetail,
    };
  },
  computed: {
    ...mapState("member", ["addressList"]),
    imgPathSingleY() {
      return require("@/assets/images/icon_check-only_y.svg");
    },
  },
  methods: {
    ...mapActions("member", [`${SET_CHANGE_MODE}`]),
    onClickCheckBoxBtn(idx) {
      // 상위 컴포넌트로 이벤트 발생
      this.$emit("open-modal", idx);
    },
    onClickConfirmBtn(idx) {
      // 0) 상세주소를 입력해 주세요
      if (!this.input) {
        alert("상세 주소를 입력해 주세요.");
        return;
      }

      // 1) Front vuex의 addressDetail 변경
      for (let i = 0; i < this.addressList.length; i++) {
        if (this.addressList[i].idx === idx) {
          this.$store.commit(`member/${SET_ADDRESS_DETAIL}`, {
            index: i,
            inputText: this.input,
          });
        }
      }

      // 2) BackEnd의 addressDetail 변경 ( *Axios 로직 )

      // 3) 상세 주소 편집 모드 해제
      this.quitEditMode(idx);
    },
    onClickCancelBtn(idx) {
      // 1) 원래 데이터 보관
      const originText = this.addressObj.addressDetail;

      // 2) 원래 데이터 input에 적용
      this.input = originText;

      // 3) 상세 주소 편집 모드 해제
      this.quitEditMode(idx);
    },
    quitEditMode(idx) {
      const addressList = this.addressList;
      for (let i = 0; i < addressList.length; i++) {
        if (addressList[i].idx === idx) {
          this.$store.commit(`member/${SET_CHANGE_MODE}`, {
            index: i,
            boolean: false,
          });
          break;
        }
      }
    },
    onClickEditBtn(idx) {
      const addressList = this.addressList;
      let indexToCancel = -1;
      let indexToEdit = -1;
      for (let i = 0; i < addressList.length; i++) {
        if (addressList[i].changeMode === true) {
          indexToCancel = i;
        }
        if (addressList[i].idx === idx) {
          indexToEdit = i;
        }
      }
      this.SET_CHANGE_MODE({ indexToCancel, indexToEdit });
    },
  },
};
</script>

<style></style>
