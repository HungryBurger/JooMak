export const TOGGLE_ON_HOME = "TOGGLE_ON_HOME";
export const SET_CURRENT_PAGE = "SET_CURRENT_PAGE";
export const SET_CURRENT_HOME_COORDS = "SET_CURRENT_HOME_COORDS";

export const common = {
  namespaced: true,
  state: () => ({
    onHome: true,
    onLogin: false,
    currentPage: "homePage",
    currentHomeCoords: "morning",
  }),
  getters: {},
  mutations: {
    [TOGGLE_ON_HOME](state) {
      state.onHome = state.onHome == true ? false : true;
    },
    [SET_CURRENT_PAGE](state, pageName) {
      state.currentPage = pageName;
    },
    [SET_CURRENT_HOME_COORDS](state, coordsName) {
      state.currentHomeCoords = coordsName;
    },
  },
  actions: {},
};
