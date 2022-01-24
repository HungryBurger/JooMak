<template>
  <div v-if="orderFormList.length > 0" id="orderPage">
    <header>
      <h3>주문 / 결제</h3>
      <img :src="iconJoomakPath" alt="icon_joomak" class="icon_joomak" />
      <img :src="iconJoomoPath" alt="icon_joomo" class="icon_joomo" />
      <img :src="iconChefHatPath" alt="icon_chef-hat" class="icon_chef-hat" />
    </header>
    <div class="content">
      <GroupBox title="주문 정보">
        <template v-slot:content>
          <table class="order_table">
            <colgroup>
              <col width="15%" />
              <col width="20%" />
              <col width="10%" />
              <col width="25%" />
              <col width="15%" />
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

      <GroupBox title="배달지 정보">
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

      <GroupBox title="요청 사항">
        <template v-slot:content>
          <div class="customer-request_box">
            <div>
              <div class="message_box owner">
                <div>
                  <img
                    :src="iconFaceJoomoPath"
                    alt="joomo-face"
                    class="icon_face-joomo"
                  />
                  <span>사장님께</span>
                </div>
                <div class="dropdown">
                  <button
                    class="btn btn-warning dropdown-toggle"
                    id="message-to-owner_dropdown"
                    data-bs-toggle="dropdown"
                    aria-expanded="false"
                  >
                    {{ selectedMessageToOwner }}
                  </button>
                  <ul
                    class="dropdown-menu"
                    aria-labelledby="message-to-owner_dropdown"
                  >
                    <li
                      v-for="(messageToOwner, i) in messageToOwnerList"
                      :key="i"
                    >
                      <a
                        class="dropdown-item"
                        :data-message-owner="messageToOwner"
                        @click="onClickMessageToOwner($event)"
                        >{{ messageToOwner }}</a
                      >
                    </li>
                  </ul>
                </div>
              </div>
              <div class="message_box rider">
                <div>
                  <img
                    :src="iconFaceRiderPath"
                    alt="rider-face"
                    class="icon_face-rider"
                  />
                  <span>라이더님께</span>
                </div>
                <div class="dropdown">
                  <button
                    class="btn btn-primary dropdown-toggle"
                    id="message-to-rider_dropdown"
                    data-bs-toggle="dropdown"
                    aria-expanded="false"
                  >
                    {{ selectedMessageToRider }}
                  </button>
                  <ul
                    class="dropdown-menu"
                    aria-labelledby="message-to-rider_dropdown"
                  >
                    <li
                      v-for="(messageToRider, i) in messageToRiderList"
                      :key="i"
                    >
                      <a
                        class="dropdown-item"
                        :data-message-rider="messageToRider"
                        @click="onClickMessageToRider($event)"
                        >{{ messageToRider }}</a
                      >
                    </li>
                  </ul>
                </div>
              </div>
            </div>
            <div>
              <label>
                <input type="checkbox" />
                &nbsp;&nbsp;다음 주문에도 이 요청 사용하기
              </label>
            </div>
          </div>
        </template>
      </GroupBox>

      <GroupBox title="결제 수단 선택">
        <template v-slot:content>
          <div class="web-pay_wrap pay_wrap">
            <div>
              <img :src="iconWebPayPath" alt="icon_web-pay" />
              <h4>웹 결제</h4>
              <span>* 웹에서 미리 결제</span>
            </div>
            <div class="pay_box">
              <div class="pay_btn danal">
                <img :src="logoDanalPath" alt="logo_danal" />
                <span>신용카드</span>
              </div>
              <div class="pay_btn naver-pay">
                <img :src="logoNaverPayPath" alt="logo_naver-pay" />
                <span>네이버페이</span>
              </div>
              <div class="pay_btn kakao-pay">
                <img :src="logoKakaoPayPath" alt="logo_kakao-pay" />
                <span>카카오페이</span>
              </div>
            </div>
          </div>

          <div class="meet-pay_wrap pay_wrap">
            <div>
              <img :src="iconMeetPayPath" alt="icon_meet-pay" />
              <h4>현장 결제</h4>
              <span>* 음식 받고 직접 결제</span>
            </div>
            <div class="pay_box">
              <div class="pay_btn credit-card">
                <img :src="iconCreditCardPath" alt="icon_credit-card" />
                <span>신용카드</span>
              </div>
              <div class="pay_btn dollar">
                <img :src="iconDollarPath" alt="icon_dollar" />
                <span>현금결제</span>
              </div>
            </div>
          </div>
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

      selectedMessageToOwner: "선택 없음",
      messageToOwnerList: [
        "선택 없음",
        "수저는 안주셔도 돼요.",
        "사장님 부자되세요 ^-^ !!",
        "맛있게 부탁드립니다!",
      ],

      selectedMessageToRider: "선택 없음",
      messageToRiderList: [
        "선택 없음",
        "조심히 안전히 오세요!",
        "빠른 배달 부탁드려요.",
        "기사님 좋은하루 되세요~!!",
      ],
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
    iconFaceJoomoPath() {
      return require("@/assets/images/icon_face-joomo.svg");
    },
    iconFaceRiderPath() {
      return require("@/assets/images/icon_face-rider.svg");
    },
    iconWebPayPath() {
      return require("@/assets/images/icon_web-pay.png");
    },
    iconMeetPayPath() {
      return require("@/assets/images/icon_meet-pay.png");
    },
    logoDanalPath() {
      return require("@/assets/images/logo_danal.png");
    },
    logoNaverPayPath() {
      return require("@/assets/images/logo_naver-pay.jpg");
    },
    logoKakaoPayPath() {
      return require("@/assets/images/logo_kakao-pay.png");
    },
    iconCreditCardPath() {
      return require("@/assets/images/icon_credit-card.png");
    },
    iconDollarPath() {
      return require("@/assets/images/icon_dollar.png");
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
    onClickMessageToOwner(e) {
      this.selectedMessageToOwner = e.target.dataset.messageOwner;
    },
    onClickMessageToRider(e) {
      this.selectedMessageToRider = e.target.dataset.messageRider;
    },
  },
};
</script>

<style></style>
