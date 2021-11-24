<template>
  <modal-component v-if="onAddressConfigModal" @close="closeModal">
    <template v-slot:header>
      <div class="no-use"></div>
    </template>
    <template v-slot:content>주소 설정 Modal</template>
    <template v-slot:footer>
      <div class="no-use"></div>
    </template>
  </modal-component>
</template>

<script>
import ModalComponent from "@/components/client/common/share/pages/ModalComponent.vue";
import { mapState } from "vuex";
import { SET_ON_ADDRESS_CONFIG_MODAL } from "@/store/modules/common.js";

export default {
  components: {
    ModalComponent,
  },
  computed: {
    ...mapState("common", ["onAddressConfigModal"]),
  },
  methods: {
    closeModal() {
      this.$store.commit(`common/${SET_ON_ADDRESS_CONFIG_MODAL}`, false);
    },
  },
};
</script>

<style></style>
