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
      <!-- <ConfirmModal /> -->

      <h3>배달지 설정</h3>
      <div class="section_title">현재 주소</div>
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
      <div class="section_title">주소 목록</div>
      <table>
        <th>현재 주소</th>
        <th>주소명</th>
        <th colspan="3">주소</th>
        <address-list-tr
          v-for="addressObj in addressList"
          :key="addressObj.idx"
          :addressObj="addressObj"
          @open-modal="openConfirmAddressConfig"
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
      confirmAddressConfig: false,
      // confirmADeleteAddress: false,
    };
  },
  computed: {
    ...mapState("common", ["onAddressConfigModal"]),
    ...mapState("member", ["addressList"]),
    ...mapGetters("member", ["currentAddressObj"]),
    iconAlertPath() {
      return require("@/assets/images/icon_home_alert.svg");
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
  },
};
</script>

<style></style>
