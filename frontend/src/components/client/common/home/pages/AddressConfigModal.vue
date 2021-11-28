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
      <h3>배달지 설정</h3>
      <div class="section_title">현재 주소</div>
      <div v-if="!currentAddress" class="section_content">
        <b>* 현재 등록된 주소가 없습니다.</b>
      </div>
      <div v-else class="section_content">
        <div>asdf</div>
        <div>sdfsdf</div>
      </div>
      <br />
      <div class="section_title">주소 목록</div>
    </template>
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
    ...mapState("member", ["currentAddress"]),
  },
  methods: {
    closeModal() {
      this.$store.commit(`common/${SET_ON_ADDRESS_CONFIG_MODAL}`, false);
    },
  },
};
</script>

<style></style>
