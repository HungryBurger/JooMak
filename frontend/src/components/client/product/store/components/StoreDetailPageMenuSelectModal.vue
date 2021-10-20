<template>
  <modal-component @close="closeModal" v-if="onModal">
    <template v-slot:header>
      <div class="no-use"></div>
    </template>
    <template v-slot:content>
      <div class="modal_left">
        <div class="modal_img_wrap">
          <img
            :src="selectedProductBasicInfo.img"
            :alt="selectedProductBasicInfo.imgAlt"
          />
        </div>
        <div class="modal_menu-info_box">
          <div class="modal_menu_title">
            <h3 class="modal_menu_name">{{ selectedProductBasicInfo.name }}</h3>
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
        <menu-select-tab-modal-option-box
          v-for="singleOption in orderForm.options.singleOptionGroup"
          :key="singleOption.optionGroupIdx"
          :singleOption="singleOption"
        ></menu-select-tab-modal-option-box>
        <menu-select-tab-modal-option-box
          v-for="multiOption in orderForm.options.multiOptionGroup"
          :key="multiOption.optionGroupIdx"
          :multiOption="multiOption"
        ></menu-select-tab-modal-option-box>
        <div class="input-number-box_area">
          <div class="input-number-box_wrap">
            <div class="input-number-box">
              <div class="number_minus number_btn" @click="onClickMinusBtn">
                <svg
                  width="50"
                  height="50"
                  viewBox="0 0 50 50"
                  fill="none"
                  xmlns="http://www.w3.org/2000/svg"
                >
                  <circle
                    cx="25"
                    cy="25"
                    r="22.5"
                    fill="white"
                    stroke="#FFDD1B"
                    stroke-width="5"
                  />
                  <rect
                    x="15"
                    y="22"
                    width="20"
                    height="6"
                    rx="3"
                    fill="#FFDD1C"
                  />
                </svg>
              </div>
              <span class="input-number">{{ orderForm.numberOfProduct }}</span>
              <div class="number_plus number_btn" @click="onClickPlusBtn">
                <svg
                  width="50"
                  height="50"
                  viewBox="0 0 50 50"
                  fill="none"
                  xmlns="http://www.w3.org/2000/svg"
                >
                  <circle
                    cx="25"
                    cy="25"
                    r="22.5"
                    fill="white"
                    stroke="#FFDD1B"
                    stroke-width="5"
                  />
                  <rect
                    x="15"
                    y="22"
                    width="20"
                    height="6"
                    rx="3"
                    fill="#FFDD1C"
                  />
                  <rect
                    x="22"
                    y="15"
                    width="6"
                    height="20"
                    rx="3"
                    fill="#FFDD1C"
                  />
                </svg>
              </div>
            </div>
          </div>
        </div>
      </div>
    </template>
    <template v-slot:footer>
      <div class="no-use"></div>
    </template>
  </modal-component>
</template>

<script>
import { mapActions, mapState } from "vuex";
import ModalComponent from "@/components/client/common/share/pages/ModalComponent.vue";
import MenuSelectTabModalOptionBox from "./MenuSelectTabModalOptionBox.vue";
import { MINUS_PRODUCT_NUM, PLUS_PRODUCT_NUM } from "@/store/modules/order.js";

export default {
  components: {
    ModalComponent,
    MenuSelectTabModalOptionBox,
  },
  computed: {
    ...mapState("common", ["onModal"]),
    ...mapState("product", ["selectedProductBasicInfo"]),
    ...mapState("order", ["orderForm"]),
    detailInfoNextLine() {
      return this.selectedProductBasicInfo.detailInfo.replaceAll(
        "\n",
        "<br />"
      );
    },
    price() {
      let num = this.selectedProductBasicInfo.price;
      return num.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    },
  },
  methods: {
    ...mapActions("order", [MINUS_PRODUCT_NUM, PLUS_PRODUCT_NUM]),
    closeModal() {
      console.log("close event 발생");
    },
    onClickMinusBtn() {
      this.MINUS_PRODUCT_NUM();
    },
    onClickPlusBtn() {
      this.PLUS_PRODUCT_NUM();
    },
  },
};
</script>

<style scoped></style>
