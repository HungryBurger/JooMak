<template>
  <modal-component
    v-if="onAddressConfigRequestModal"
    @close="closeModal"
    class="modal_home_alert"
    @wheel.prevent
  >
    <template v-slot:header>
      <div class="no-use"></div>
    </template>
    <template v-slot:content>
      <div
        class="modal_text d-flex flex-column justify-content-center align-items-center"
      >
        <div class="fw-bold">
          <span>먼저 주소를 설정해 주세요!</span>
        </div>
        <div>* 주소는 홈에서만 변경할 수 있습니다.</div>
      </div>
    </template>
    <template v-slot:footer>
      <div
        @click="onClickConfirmBtn"
        class="modal_alert-confirm_btn d-flex justify-content-center align-items-center"
      >
        확인
      </div>
    </template>
  </modal-component>
</template>

<script>
import ModalComponent from "@/components/client/common/share/pages/ModalComponent.vue";
import { mapActions, mapState } from "vuex";
import {
  CLOSE_ADDRESS_CONFIG_REQUEST_MODAL,
  OPEN_ADDRESS_CONFIG_MODAL,
} from "@/store/modules/common.js";

export default {
  components: {
    ModalComponent,
  },
  computed: {
    ...mapState("common", ["currentPage", "onAddressConfigRequestModal"]),
  },
  methods: {
    ...mapActions("common", [
      `${CLOSE_ADDRESS_CONFIG_REQUEST_MODAL}`,
      `${OPEN_ADDRESS_CONFIG_MODAL}`,
    ]),
    closeModal() {
      this.CLOSE_ADDRESS_CONFIG_REQUEST_MODAL();
    },
    onClickConfirmBtn() {
      if (this.currentPage === "homePage") {
        this.OPEN_ADDRESS_CONFIG_MODAL();
      } else {
        this.closeModal();
      }
    },
  },
};
</script>

<style></style>
