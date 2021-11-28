export const SET_CURRENT_ADDRESS = "SET_CURRENT_ADDRESS";

export const member = {
  namespaced: true,
  state: () => ({
    // currentAddress: "서울특별시 강남구 논현동 123-45",
    currentAddress: "",
    addressList: [
      {
        idx: 1,
        selected: true,
        name: "우리집",
        addressMain: "서울특별시 강남구 논현동 123-45",
        addressDetail: "3동 1101호",
      },
      {
        idx: 2,
        selected: false,
        name: "할머니 댁",
        addressMain: "",
        addressDetail: "",
      },
      {
        idx: 3,
        selected: false,
        name: "사무실",
        addressMain: "",
        addressDetail: "",
      },
    ],
  }),
  getters: {},
  mutations: {},
  actions: {
    [SET_CURRENT_ADDRESS](state) {},
  },
};
