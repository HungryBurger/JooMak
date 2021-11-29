export const SET_CURRENT_ADDRESS = "SET_CURRENT_ADDRESS";

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
      },
      {
        idx: 2,
        selected: false,
        name: "할머니 댁",
        addressMain: "서울특별시 광진구 화양동 456-12",
        addressDetail: "105동 115호",
      },
      {
        idx: 3,
        selected: false,
        name: "사무실",
        addressMain: "서울특별시 송파구 잠실동 765-43",
        addressDetail: "L타워 4602호",
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
  mutations: {},
  actions: {
    [SET_CURRENT_ADDRESS](state) {},
  },
};
