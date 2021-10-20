/* 매장 상세 페이지 */
// 리뷰 탭 - Modal
export const SET_ORDER_FORM = "SET_ORDER_FORM";
export const SET_SINGLE_OPTION_LI = "SET_SINGLE_OPTION_LI";
export const TOGGLE_MULTI_OPTION_LI = "TOGGLE_MULTI_OPTION_LI";
export const TOGGLE_OPTION_LI = "TOGGLE_OPTION_LI";

export const order = {
  namespaced: true,
  state: () => ({
    orderForm: {
      storeIdx: 0,
      groupIdx: 0,
      productIdx: 0,
      name: "",
      price: 0,
      options: {
        singleOptionGroup: [
          {
            optionGroupIdx: 1,
            optionGroupName: "감자튀김 사이즈",
            selectedOptionIdx: 1,
            optionList: [
              {
                optionIdx: 1,
                optionName: "M (미디움)",
                price: 0,
              },
              {
                optionIdx: 2,
                optionName: "L (라지)",
                price: 500,
              },
            ],
          },
          {
            optionGroupIdx: 2,
            optionGroupName: "음료 변경",
            selectedOptionIdx: 1,
            optionList: [
              {
                optionIdx: 1,
                optionName: "코카콜라",
                price: 0,
              },
              {
                optionIdx: 2,
                optionName: "스프라이트",
                price: 500,
              },
              {
                optionIdx: 3,
                optionName: "환타 오렌지",
                price: 1000,
              },
            ],
          },
        ],
        multiOptionGroup: [
          {
            optionGroupIdx: 1,
            optionGroupName: "감자튀김 시즈닝",
            optionList: [
              {
                optionIdx: 1,
                optionName: "뿌링클",
                price: 500,
              },
              {
                optionIdx: 2,
                optionName: "핫 시즈닝",
                price: 500,
              },
              {
                optionIdx: 3,
                optionName: "바베큐 시즈닝",
                price: 1000,
              },
            ],
          },
        ],
      },
      numberOfProduct: 1,
    },
  }),
  getters: {},
  mutations: {
    [SET_ORDER_FORM](state, orderForm) {
      state.orderForm = orderForm;
    },
    [SET_SINGLE_OPTION_LI](state, { optionGroupIndex, optionIdx }) {
      state.orderForm.options.singleOptionGroup[
        optionGroupIndex
      ].selectedOptionIdx = optionIdx;
    },
    [TOGGLE_MULTI_OPTION_LI](state, { optionGroupIndex, optionIndex }) {
      state.orderForm.options.multiOptionGroup[optionGroupIndex].optionList[
        optionIndex
      ].onSelected = state.orderForm.options.multiOptionGroup[optionGroupIndex]
        .optionList[optionIndex].onSelected
        ? false
        : true;
    },
  },
  actions: {
    [TOGGLE_OPTION_LI](
      { state, commit },
      { optionInfo, singleOption, multiOption, orderForm }
    ) {
      if (singleOption) {
        const singleOptionGroup = orderForm.options.singleOptionGroup;
        let optionGroupIndex;
        let optionIdx = optionInfo.optionIdx;
        // optionGroupIndex 찾기
        for (let i = 0; i < singleOptionGroup.length; i++) {
          if (
            singleOptionGroup[i].optionGroupIdx === singleOption.optionGroupIdx
          ) {
            optionGroupIndex = i;
            break;
          }
        }
        commit(SET_SINGLE_OPTION_LI, { optionGroupIndex, optionIdx });
      } else if (multiOption) {
        const multiOptionGroup = orderForm.options.multiOptionGroup;
        let optionGroupIndex;
        let optionIndex;
        // optionGroupIndex 찾기
        for (let i = 0; i < multiOptionGroup.length; i++) {
          if (
            multiOptionGroup[i].optionGroupIdx === multiOption.optionGroupIdx
          ) {
            optionGroupIndex = i;
            break;
          }
        }
        // optionIndex 찾기
        for (let i = 0; i < multiOption.optionList.length; i++) {
          if (multiOption.optionList[i].optionIdx === optionInfo.optionIdx) {
            optionIndex = i;
            break;
          }
        }
        commit(TOGGLE_MULTI_OPTION_LI, { optionGroupIndex, optionIndex });
      }
    },
  },
};
