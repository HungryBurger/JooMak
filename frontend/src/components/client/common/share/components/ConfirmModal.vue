<template>
  <modal-component
    v-if="condition ? condition : onConfirmModal"
    @close="onClickCancelBtn"
    class="confirm_modal"
    @wheel.prevent
  >
    <template v-slot:header>
      <div class="no-use"></div>
    </template>
    <template v-slot:content>
      <div class="text_wrap">
        <div class="icon_wrap">
          <img :src="iconAlertPath" alt="icon_alert" />
        </div>
        <span class="fw-bold">{{ message }}</span>
      </div>
    </template>

    <template v-slot:footer>
      <div class="btn_wrap">
        <div
          @click="onClickConfirmBtn"
          class="btn confirm_btn d-flex justify-content-center align-items-center"
        >
          확인
        </div>
        <div
          @click="onClickCancelBtn"
          class="btn cancel_btn d-flex justify-content-center align-items-center"
        >
          취소
        </div>
      </div>
    </template>
  </modal-component>
</template>

<script>
import { mapState } from "vuex";
import ModalComponent from "@/components/client/common/share/pages/ModalComponent.vue";
import { SET_ON_CONFIRM_MODAL } from "@/store/modules/common.js";
export default {
  components: {
    ModalComponent,
  },
  props: {
    message: {
      type: String,
      required: true,
    },
    condition: {
      type: Boolean,
      required: false,
    },
  },
  computed: {
    ...mapState("common", ["onConfirmModal"]),
    iconAlertPath() {
      return require("@/assets/images/icon_home_alert.svg");
    },
  },
  methods: {
    closeConfirmModal() {
      if (this.condition) {
        // 조건 false
      } else {
        this.$store.commit(`common/${SET_ON_CONFIRM_MODAL}`, false);
      }
    },
    onClickConfirmBtn() {
      this.$emit("confirm-yes");
      if (!this.condition) {
        this.closeConfirmModal();
      }
    },
    onClickCancelBtn() {
      this.$emit("confirm-no");
      if (!this.condition) {
        this.closeConfirmModal();
      }
    },
  },
};
</script>

<style></style>
