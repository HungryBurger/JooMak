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
import AddressListTr from "@/components/client/common/home/components/AddressListTr.vue";
import { mapGetters, mapState } from "vuex";
import { SET_ON_ADDRESS_CONFIG_MODAL } from "@/store/modules/common.js";
import { SET_CHANGE_MODE } from "@/store/modules/member.js";

export default {
  components: {
    ModalComponent,
    AddressListTr,
  },
  computed: {
    ...mapState("common", ["onAddressConfigModal"]),
    ...mapState("member", ["addressList"]),
    ...mapGetters("member", ["currentAddressObj"]),
  },
  methods: {
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
  },
};
</script>

<style></style>
