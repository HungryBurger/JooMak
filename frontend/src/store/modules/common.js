export const TOGGLE_ON_HOME = "TOGGLE_ON_HOME";
export const SET_CURRENT_PAGE = "SET_CURRENT_PAGE";

export const common = {
  namespaced: true,
  state: () => ({
    commonData: "hihi 나는 common store에 있는 data야!",
    onHome: true,
    onLogin: false,
    currentPage: "homePage",
  }),
  getters: {},
  mutations: {
    [TOGGLE_ON_HOME](state) {
      state.onHome = state.onHome == true ? false : true;
    },
    [SET_CURRENT_PAGE](state, pageName) {
      state.currentPage = pageName;
    },
  },
  actions: {},
};
