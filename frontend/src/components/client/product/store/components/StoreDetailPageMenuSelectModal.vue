<template>
  <modal-component @close="closeModal" v-if="onModal">
    <template v-slot:header>
      <div class="no-use"></div>
    </template>
    <template v-slot:content>
      <div class="modal_left">
        <div class="modal_img_wrap" @wheel.prevent>
          <img
            :src="selectedProductBasicInfo.img"
            :alt="selectedProductBasicInfo.imgAlt"
          />
        </div>
        <div class="modal_menu-info_box">
          <div class="modal_menu_title">
            <h3 class="modal_menu_name" @wheel.prevent>
              {{ selectedProductBasicInfo.name }}
            </h3>

            <div
              class="modal_menu_detail-info"
              v-html="detailInfoNextLine"
            ></div>
          </div>
          <div class="modal_menu_price" @wheel.prevent>
            기본&nbsp;&nbsp;&nbsp;&nbsp;<span>{{ price }}</span
            >&nbsp;&nbsp;원
          </div>
        </div>
      </div>
      <div class="modal_right">
        <menu-select-tab-modal-option-box
          v-for="singleOption in selectedItemForm.options.singleOptionGroup"
          :key="singleOption.optionGroupIdx"
          :singleOption="singleOption"
        ></menu-select-tab-modal-option-box>
        <menu-select-tab-modal-option-box
          v-for="multiOption in selectedItemForm.options.multiOptionGroup"
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
              <span class="input-number">{{
                selectedItemForm.numberOfProduct
              }}</span>
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
        <div class="option-box">
          <div class="option-box_title">
            <span>
              선택한 옵션
            </span>
          </div>
          <div class="option-box_content selected-option">
            <ul>
              <li>
                <span>{{ selectedItemForm.name }}</span>
                <span>{{ productPrice }}</span>
              </li>
              <selected-single-option-li
                v-for="singleOption in selectedItemForm.options
                  .singleOptionGroup"
                :key="singleOption.optionGroupIdx"
                :singleOption="singleOption"
              ></selected-single-option-li>
              <selected-multi-option-li
                v-for="multiOption in selectedItemForm.options.multiOptionGroup"
                :key="multiOption.optionGroupIdx"
                :multiOption="multiOption"
              ></selected-multi-option-li>
            </ul>
            <div class="selected-option_price">
              <number-with-comma-span
                :num="selectedItemFormPrice"
                textBack="&nbsp;원"
              ></number-with-comma-span>
            </div>
            <div class="selected-option_number">
              <span>수량</span>
              <span>x {{ selectedItemForm.numberOfProduct }}</span>
            </div>
            <div class="selected-option_total-price">
              <number-with-comma-span
                :num="selectedItemFormTotalPrice"
                textFront="총&nbsp;&nbsp;"
                textBack="&nbsp;원"
              ></number-with-comma-span>
            </div>
          </div>
        </div>
        <div class="link-box">
          <router-link to="/cart">
            <div class="link_cart" @click="onClickCartLink">보따리에 담기</div>
          </router-link>
          <router-link to="/order">
            <div class="link_order" @click="onClickOrderLink">바로 주문</div>
          </router-link>
        </div>
      </div>
    </template>
    <template v-slot:footer>
      <div class="no-use"></div>
    </template>
  </modal-component>
</template>

<script>
import { mapActions, mapGetters, mapState } from "vuex";
import ModalComponent from "@/components/client/common/share/pages/ModalComponent.vue";
import MenuSelectTabModalOptionBox from "./MenuSelectTabModalOptionBox.vue";
import SelectedSingleOptionLi from "./SelectedSingleOptionLi.vue";
import SelectedMultiOptionLi from "./SelectedMultiOptionLi.vue";
import NumberWithCommaSpan from "@/components/client/common/share/components/NumberWithCommaSpan.vue";
import {
  MINUS_PRODUCT_NUM,
  PLUS_PRODUCT_NUM,
  SET_ORDER_FORM_LIST,
} from "@/store/modules/order.js";

export default {
  components: {
    ModalComponent,
    MenuSelectTabModalOptionBox,
    SelectedSingleOptionLi,
    SelectedMultiOptionLi,
    NumberWithCommaSpan,
  },
  computed: {
    ...mapState("common", ["onModal"]),
    ...mapState("product", ["selectedProductBasicInfo"]),
    ...mapState("order", ["selectedItemForm"]),
    ...mapGetters("order", [
      "selectedItemFormPrice",
      "selectedItemFormTotalPrice",
    ]),
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
    productPrice() {
      let num = this.selectedItemForm.price;
      return num.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    },
  },
  methods: {
    ...mapActions("order", [
      MINUS_PRODUCT_NUM,
      PLUS_PRODUCT_NUM,
      SET_ORDER_FORM_LIST,
    ]),
    closeModal() {
      console.log("close event 발생");
    },
    onClickMinusBtn() {
      this.MINUS_PRODUCT_NUM();
    },
    onClickPlusBtn() {
      this.PLUS_PRODUCT_NUM();
    },
    onClickCartLink() {
      console.log("보따리 btn 클릭");
      // Axios post 로직
      // this.selectedItemForm 이용
    },
    onClickOrderLink() {
      let orderFormList = [];
      Object.assign(this.selectedItemForm, {
        selected: true,
        img: this.selectedProductBasicInfo.img,
      });
      orderFormList.push(this.selectedItemForm);
      this.SET_ORDER_FORM_LIST(orderFormList);
    },
  },
};
</script>

<style scoped></style>
