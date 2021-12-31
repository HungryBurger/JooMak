<template>
  <modal-component
    v-if="onAddressConfigModal"
    @close="closeModal"
    class="address-config_modal"
  >
    <template v-slot:header>
      <div class="no-use"></div>
    </template>
    <template v-slot:content>
      <!-- 주소설정 confirm modal -->
      <ConfirmModal
        message="이 주소를 현재 주소로 설정하시겠어요?"
        :condition="confirmAddressConfig"
        @confirm-yes="confirmYesAddressConfig"
        @confirm-no="confirmNoAddressConfig"
      />

      <!-- 주소삭제 confirm modal -->
      <ConfirmModal
        message="이 주소를 주소록에서 삭제하시겠어요?"
        :condition="confirmDeleteAddress"
        @confirm-yes="confirmYesDeleteAddress"
        @confirm-no="confirmNoDeleteAddress"
      />

      <ConfirmModal
        message="주소이름과 주소를 등록해 주세요."
        :condition="confirmAddressAdd"
        @confirm-yes="confirmYesAddressAdd"
        @confirm-no="confirmNoAddressAdd"
        class="address-add_modal"
      >
        <template v-slot:content>
          <table>
            <tr>
              <th scope="row">주소명</th>
              <td>
                <input
                  type="text"
                  v-model="addressAdd.name"
                  placeholder="주소명"
                />
              </td>
            </tr>
            <tr>
              <th scope="row">주소</th>
              <td>
                <div class="input_wrap">
                  <input
                    v-model="addressAdd.addressMain"
                    class="main-address"
                    type="text"
                    placeholder="'주소검색'으로 주소를 검색하세요."
                  />
                  <button @click="onClickAddressSearchBtn">주소검색</button>
                </div>
                <input type="text" placeholder="상세주소" />
              </td>
            </tr>
          </table>
        </template>
      </ConfirmModal>

      <h3>배달지 설정</h3>
      <div class="section_title_wrap">
        <div class="section_title">현재 주소</div>
      </div>
      <div v-if="!currentAddressObj" class="section_content">
        <b>* 현재 등록된 주소가 없습니다.</b>
      </div>
      <div v-else class="section_content">
        <div class="address-name">{{ currentAddressObj.name }}</div>
        <div class="selected-address">{{ currentAddressObj.addressMain }}</div>
        <div class="selected-address">
          {{ currentAddressObj.addressDetail }}
        </div>
      </div>
      <br />
      <div class="section_title_wrap">
        <div class="section_title">주소 목록</div>
        <button class="address-add_btn" @click="onClickAddressAddBtn">
          <svg
            width="20"
            height="20"
            viewBox="0 0 20 20"
            fill="none"
            xmlns="http://www.w3.org/2000/svg"
          >
            <rect y="7" width="20" height="6" rx="3" fill="#FFC463" />
            <rect x="7" width="6" height="20" rx="3" fill="#FFC463" />
          </svg>

          <!-- <img :src="iconPlusPath" alt="icon_plus" /> -->
          <span>주소 추가</span>
        </button>
      </div>
      <table>
        <th>현재 주소</th>
        <th>주소명</th>
        <th colspan="3">주소</th>
        <address-list-tr
          v-for="addressObj in addressList"
          :key="addressObj.idx"
          :addressObj="addressObj"
          @open-modal-address-config="openConfirmAddressConfig"
          @open-modal-delete-address="openConfirmDeleteAddress"
        ></address-list-tr>
      </table>
      <div class="div-for-padding"></div>
    </template>
    <template v-slot:footer>
      <div class="no-use"></div>
    </template>
  </modal-component>
</template>

<script>
import ModalComponent from "@/components/client/common/share/pages/ModalComponent.vue";
import ConfirmModal from "@/components/client/common/share/components/ConfirmModal.vue";
import AddressListTr from "@/components/client/common/home/components/AddressListTr.vue";
import { mapActions, mapGetters, mapState } from "vuex";
import {
  SET_ON_CONFIRM_MODAL,
  SET_ON_ADDRESS_CONFIG_MODAL,
} from "@/store/modules/common.js";
import {
  SET_CHANGE_MODE,
  SET_ADDRESS_SELECTED,
} from "@/store/modules/member.js";

export default {
  components: {
    ModalComponent,
    ConfirmModal,
    AddressListTr,
  },
  data() {
    return {
      currentAddressIdxCandidate: -1,
      deleteCandidate: -1,

      confirmAddressConfig: false,
      confirmDeleteAddress: false,
      confirmAddressAdd: false,

      addressAdd: {
        responseData: {},

        name: "",
        addressMain: "",
        addressDetail: "",
        postcode: "",
      },
    };
  },
  computed: {
    ...mapState("common", ["onAddressConfigModal"]),
    ...mapState("member", ["addressList"]),
    ...mapGetters("member", ["currentAddressObj"]),
    iconAlertPath() {
      return require("@/assets/images/icon_home_alert.svg");
    },
    iconPlusPath() {
      return require("@/assets/images/icon_home_plus.svg");
    },
  },
  methods: {
    ...mapActions("member", [`${SET_ADDRESS_SELECTED}`]),
    closeModal() {
      for (let i = 0; i < this.addressList.length; i++) {
        if (this.addressList[i].changeMode === true) {
          this.$store.commit(`member/${SET_CHANGE_MODE}`, {
            index: i,
            boolean: false,
          });
          break;
        }
      }
      this.$store.commit(`common/${SET_ON_ADDRESS_CONFIG_MODAL}`, false);
    },
    onClickAddressAddBtn() {
      this.addressAdd = {
        name: "",
        addressMain: "",
        addressDetail: "",
        postcode: "",
      };
      this.confirmAddressAdd = true;
    },
    // 주소설정 confirm modal
    openConfirmAddressConfig(idx) {
      this.confirmAddressConfig = true;
      this.currentAddressIdxCandidate = idx;
    },
    confirmYesAddressConfig() {
      this.SET_ADDRESS_SELECTED(this.currentAddressIdxCandidate);
      this.confirmAddressConfig = false;
    },
    confirmNoAddressConfig() {
      this.currentAddressIdxCandidate = -1;
      this.confirmAddressConfig = false;
    },
    // 주소삭제 confirm modal
    openConfirmDeleteAddress(idx) {
      this.confirmDeleteAddress = true;
      this.deleteCandidate = idx;
    },
    confirmYesDeleteAddress() {
      // 주소 삭제 로직 삽입 예정 ( * vuex actions 사용 예정 )
      this.confirmDeleteAddress = false;
      alert("주소가 삭제되었습니다.");
    },
    confirmNoDeleteAddress() {
      this.confirmDeleteAddress = false;
    },
    // 주소추가 confirm modal
    async confirmYesAddressAdd() {
      // validation
      const { name, addressMain } = this.addressAdd;
      if (name.trim() === "" || name === undefined || name === null) {
        alert("주소명을 입력해 주세요.");
        return;
      }
      if (
        addressMain.trim() === "" ||
        addressMain === undefined ||
        addressMain === null
      ) {
        alert("주소를 등록해 주세요.");
        return;
      }

      // axios 로직
      // this.addressAdd.responseData = await this.$axios.post();

      this.confirmAddressAdd = false;
    },
    confirmNoAddressAdd() {
      this.confirmAddressAdd = false;
    },

    onClickAddressSearchBtn() {
      new window.daum.Postcode({
        oncomplete: (data) => {
          if (this.addressAdd.addressDetail !== "") {
            this.addressAdd.addressDetail = "";
          }
          if (data.userSelectedType === "R") {
            // 사용자가 도로명 주소를 선택했을 경우
            this.addressAdd.addressMain = data.roadAddress;
          } else {
            // 사용자가 지번 주소를 선택했을 경우(J)
            this.addressAdd.addressMain = data.jibunAddress;
          }

          // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
          if (data.userSelectedType === "R") {
            // 법정동명이 있을 경우 추가한다. (법정리는 제외)
            // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
            if (data.bname !== "" && /[동|로|가]$/g.test(data.bname)) {
              this.addressAdd.addressDetail += data.bname;
            }
            // 건물명이 있고, 공동주택일 경우 추가한다.
            if (data.buildingName !== "" && data.apartment === "Y") {
              this.addressAdd.addressDetail +=
                this.addressAdd.addressDetail !== ""
                  ? `, ${data.buildingName}`
                  : data.buildingName;
            }
            // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
            if (this.addressAdd.addressDetail !== "") {
              this.addressAdd.addressDetail = `(${this.addressAdd.addressDetail})`;
            }
          } else {
            this.addressAdd.addressDetail = "";
          }
          // 우편번호를 입력한다.
          this.postcode = data.zonecode;
        },
      }).open();
    },
  },
};
</script>

<style></style>
