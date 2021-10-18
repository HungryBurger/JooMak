<template>
  <modal-component @close="closeModal" v-if="onModal">
    <template v-slot:header>
      <div class="no-use"></div>
    </template>
    <template v-slot:content>
      <div class="modal_left">
        <div class="modal_img_wrap">
          <img
            :src="modalSelectedProduct.img"
            :alt="modalSelectedProduct.imgAlt"
          />
        </div>
        <div class="modal_menu-info_box">
          <div class="modal_menu_title">
            <h3 class="modal_menu_name">{{ modalSelectedProduct.name }}</h3>
            <div
              class="modal_menu_detail-info"
              v-html="detailInfoNextLine"
            ></div>
          </div>
          <div class="modal_menu_price">
            기본&nbsp;&nbsp;&nbsp;&nbsp;<span>{{ price }}</span
            >&nbsp;&nbsp;원
          </div>
        </div>
      </div>
      <div class="modal_right">
        <!-- <menu-select-tab-modal-option-box
          v-for="singleOption in modalSelectedProduct.options.singleOptionGroup"
          :key="singleOption.optionGroupIdx"
          :singleOption="singleOption"
        ></menu-select-tab-modal-option-box>
        <menu-select-tab-modal-option-box
          v-for="multiOption in modalSelectedProduct.options.multiOptionGroup"
          :key="multiOption.optionGroupIdx"
          :multiOption="multiOption"
        ></menu-select-tab-modal-option-box> -->
      </div>
    </template>
    <template v-slot:footer>
      <div class="no-use"></div>
    </template>
  </modal-component>
</template>

<script>
import { mapState } from "vuex";
import ModalComponent from "@/components/client/common/share/pages/ModalComponent.vue";
// import MenuSelectTabModalOptionBox from "./MenuSelectTabModalOptionBox.vue";

export default {
  components: {
    ModalComponent,
    // MenuSelectTabModalOptionBox,
  },
  computed: {
    ...mapState("common", ["onModal"]),
    ...mapState("product", ["modalSelectedProduct"]),
    detailInfoNextLine() {
      return this.modalSelectedProduct.detailInfo.replaceAll("\n", "<br />");
    },
    price() {
      let num = this.modalSelectedProduct.price;
      return num.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    },
  },
  methods: {
    closeModal() {
      console.log("close event 발생");
    },
  },
};
</script>

<style scoped></style>
