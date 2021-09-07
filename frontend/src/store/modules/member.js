export const SET_CURRENT_ADDRESS = "SET_CURRENT_ADDRESS";

export const member = {
  namespaced: true,
  state: () => ({
    currentAddress: "서울특별시 강남구 논현동 123-45",
  }),
  getters: {},
  mutations: {},
  actions: {
    [SET_CURRENT_ADDRESS](state) {},
  },
};
