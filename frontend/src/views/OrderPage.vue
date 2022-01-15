<template>
  <div v-if="orderFormList.length > 0" id="orderPage">
    <header>
      <h3>주문 / 결제</h3>
      <img :src="iconJoomakPath" alt="icon_joomak" class="icon_joomak" />
      <img :src="iconJoomoPath" alt="icon_joomo" class="icon_joomo" />
      <img :src="iconChefHatPath" alt="icon_chef-hat" class="icon_chef-hat" />
    </header>
    <div class="content">
      <GroupBox title="주문정보">
        <template v-slot:content>
          <table class="order_table">
            <colgroup>
              <col width="15%" />
              <col width="20%" />
              <col width="10%" />
              <col width="30%" />
              <col width="10%" />
              <col width="15%" />
            </colgroup>

            <thead>
              <tr>
                <th scope="col" class="img_th"></th>
                <th scope="col">이름</th>
                <th scope="col">기본 가격</th>
                <th scope="col">옵션 & 가격</th>
                <th scope="col">수량 및 계</th>
                <th scope="col">총액</th>
              </tr>
            </thead>

            <tbody v-if="orderFormList.length > 0">
              <tr v-for="(orderForm, i) in orderFormList" :key="i">
                <td class="img_td">
                  <img :src="orderForm.img" :alt="`${orderForm.name}_이미지`" />
                </td>
                <td>{{ orderForm.name }}</td>
                <td>
                  <NumberWithCommaSpan :num="orderForm.price" />
                </td>
                <td class="option_td">
                  <template
                    v-if="
                      orderForm.options.singleOptionGroup.length > 0 ||
                        orderForm.options.multiOptionGroup.length > 0
                    "
                  >
                    <ul>
                      <li
                        v-for="(singleOption, j) in orderForm.options
                          .singleOptionGroup"
                        :key="j"
                      >
                        <div>
                          <span>({{ singleOption.optionGroupName }})</span>
                          <span>{{
                            singleOption.optionList.filter(
                              (option) =>
                                option.optionIdx ==
                                singleOption.selectedOptionIdx
                            )[0].optionName
                          }}</span>
                        </div>
                        <span>{{
                          singleOption.optionList.filter(
                            (option) =>
                              option.optionIdx == singleOption.selectedOptionIdx
                          )[0].price
                        }}</span>
                      </li>
                      <li
                        v-for="(multiOption, k) in orderForm.options
                          .multiOptionGroup"
                        :key="k"
                      >
                        <ul>
                          <template
                            v-for="(optionOfMultiOption,
                            l) in multiOption.optionList"
                          >
                            <li
                              v-if="optionOfMultiOption.onSelected === true"
                              :key="l"
                            >
                              <div>
                                <span>({{ multiOption.optionGroupName }})</span>
                                <span>{{
                                  optionOfMultiOption.optionName
                                }}</span>
                              </div>
                              <span>{{ optionOfMultiOption.price }}</span>
                            </li>
                          </template>
                        </ul>
                      </li>
                    </ul>
                  </template>
                  <template v-else>
                    <span>-</span>
                  </template>
                </td>
                <td class="price_td">
                  <div>
                    <NumberWithCommaSpan
                      :num="orderFormPrice(orderForm)"
                      textBack=" 원"
                    />
                  </div>
                  <div>x {{ orderForm.numberOfProduct }} 개</div>
                  <br />
                  <div>
                    <NumberWithCommaSpan
                      :num="orderFormTotalPrice(orderForm)"
                      textFront="=> "
                      textBack=" 원"
                    />
                  </div>
                </td>
                <td :rowspan="orderFormList.length">
                  <NumberWithCommaSpan
                    :num="orderFormListPrice(orderFormList)"
                    textBack=" 원"
                  />
                </td>
              </tr>

              <tr>
                <td colspan="5" class="total_td">비고</td>
                <td>3,500 원</td>
              </tr>
            </tbody>

            <tbody v-else>
              <td colspan="6">주문할 상품이 없습니다.</td>
            </tbody>
          </table>
        </template>
      </GroupBox>

      <GroupBox title="배달지정보">
        <template v-slot:content>
          <table class="address-info_table">
            <colgroup>
              <col width="15%" />
              <col width="85%" />
            </colgroup>

            <tr>
              <th scope="row">주소</th>
              <td class="address_td">
                <div>
                  <div>{{ currentAddressObj.addressMain }}</div>
                  <input
                    type="text"
                    v-model="currentAddressObj.addressDetail"
                    placeholder="상세 주소를 입력해 주세요."
                  />
                </div>
              </td>
            </tr>
            <tr>
              <th scope="row">연락처</th>
              <td class="phone_td">
                <div>
                  <input
                    type="text"
                    maxlength="3"
                    v-model="phoneNum1"
                    @input="onInputPhoneNum($event, 1)"
                  />
                  &nbsp;-&nbsp;
                  <input
                    id="phoneNum2"
                    type="text"
                    maxlength="4"
                    v-model="phoneNum2"
                    @input="onInputPhoneNum($event, 2)"
                  />
                  &nbsp;-&nbsp;
                  <input
                    id="phoneNum3"
                    type="text"
                    maxlength="4"
                    v-model="phoneNum3"
                    @input="onInputPhoneNum($event, 3)"
                  />
                </div>
              </td>
            </tr>
          </table>
        </template>
      </GroupBox>
    </div>
  </div>
  <div v-else id="orderPage">
    주문할 상품이 없습니다.
  </div>
</template>

<script>
import GroupBox from "@/components/client/common/share/components/GroupBox.vue";
import NumberWithCommaSpan from "@/components/client/common/share/components/NumberWithCommaSpan.vue";
import { mapGetters, mapState } from "vuex";

export default {
  components: { GroupBox, NumberWithCommaSpan },
  data() {
    return {
      phoneNum1: "",
      phoneNum2: "",
      phoneNum3: "",
    };
  },
  computed: {
    ...mapState("order", ["orderFormList"]),
    ...mapGetters("order", [
      "orderFormPrice",
      "orderFormTotalPrice",
      "orderFormListPrice",
    ]),
    ...mapGetters("member", ["currentAddressObj"]),
    iconJoomakPath() {
      return require("@/assets/images/icon_order_joomak.svg");
    },
    iconJoomoPath() {
      return require("@/assets/images/icon_order_joomo.svg");
    },
    iconChefHatPath() {
      return require("@/assets/images/icon_order_chef-hat.svg");
    },
  },
  created() {
    scrollTo(0, 0);
  },
  methods: {
    onInputPhoneNum(e, inputSeq) {
      let inputNum = e.target.value.replace(/[^0-9]/g, "");
      switch (inputSeq) {
        case 1: {
          this.phoneNum1 = inputNum;

          if (this.phoneNum1.length === 3) {
            document.querySelector("#phoneNum2").focus();
          }
          return;
        }
        case 2: {
          this.phoneNum2 = inputNum;

          if (this.phoneNum2.length === 4) {
            document.querySelector("#phoneNum3").focus();
          }
          return;
        }
        case 3: {
          this.phoneNum3 = inputNum;
          return;
        }
      }
    },
  },
};
</script>

<style></style>
