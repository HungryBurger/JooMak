export const SET_ADDRESS_DETAIL = "SET_ADDRESS_DETAIL";
export const SET_CHANGE_MODE = "SET_CHANGE_MODE";

export const member = {
  namespaced: true,
  state: () => ({
    addressList: [
      {
        idx: 1,
        selected: false,
        name: "우리집",
        addressMain: "서울특별시 강남구 논현동 123-45",
        addressDetail: "3동 1101호",
        changeMode: false,
      },
      {
        idx: 2,
        selected: false,
        name: "할머니 댁",
        addressMain: "서울특별시 광진구 화양동 456-12",
        addressDetail: "105동 115호",
        changeMode: false,
      },
      {
        idx: 3,
        selected: false,
        name: "사무실",
        addressMain: "서울특별시 송파구 잠실동 765-43",
        addressDetail: "L타워 4602호",
        changeMode: false,
      },
      {
        idx: 4,
        selected: true,
        name: "이모 댁",
        addressMain: "서울특별시 송파구 잠실동 765-43",
        addressDetail: "A빌라 303호",
        changeMode: false,
      },
    ],
  }),
  getters: {
    currentAddressObj(state) {
      let currentAddressObj = {};
      for (let i = 0; i < state.addressList.length; i++) {
        if (state.addressList[i].selected === true) {
          currentAddressObj = state.addressList[i];
          return currentAddressObj;
        }
      }
      return null;
    },
  },
  mutations: {
    [SET_ADDRESS_DETAIL](state, { index, inputText }) {
      state.addressList[index].addressDetail = inputText;
    },
    [SET_CHANGE_MODE](state, { index, boolean }) {
      state.addressList[index].changeMode = boolean;
    },
  },
  actions: {
    [SET_CHANGE_MODE]({ commit }, { indexToCancel, indexToEdit }) {
      if (indexToCancel !== -1) {
        commit(SET_CHANGE_MODE, { index: indexToCancel, boolean: false });
      }
      commit(SET_CHANGE_MODE, { index: indexToEdit, boolean: true });
    },
  },
};
