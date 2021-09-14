// common
export const SET_CURRENT_PAGE = "SET_CURRENT_PAGE";

// homePage
export const TOGGLE_ON_HOME = "TOGGLE_ON_HOME";
export const SET_ON_HOME = "SET_ON_HOME";
export const SET_CURRENT_HOME_COORDS = "SET_CURRENT_HOME_COORDS";

// storeListPage
export const SET_ON_PREVIEW_BOX = "SET_ON_PREVIEW_BOX";
export const SET_PREVIEW_TAB = "SET_PREVIEW_TAB";

export const common = {
  namespaced: true,
  state: () => ({
    // common
    onLogin: false,
    currentPage: "homePage",

    // homePage
    onHome: false,
    currentHomeCoords: "morning",

    // storeListPage
    onPreviewBox: true,
    previewTab: "info",
  }),
  getters: {},
  mutations: {
    // common
    [SET_CURRENT_PAGE](state, pageName) {
      state.currentPage = pageName;
    },

    // homePage
    [TOGGLE_ON_HOME](state) {
      state.onHome = state.onHome == true ? false : true;
    },
    [SET_ON_HOME](state, boolean) {
      state.onHome = boolean;
    },
    [SET_CURRENT_HOME_COORDS](state, coordsName) {
      state.currentHomeCoords = coordsName;
    },

    // storeListPage
    [SET_ON_PREVIEW_BOX](state, boolean) {
      state.onPreviewBox = boolean;
    },
    [SET_PREVIEW_TAB](state, tabName) {
      state.previewTab = tabName;
    },
  },
  actions: {},
};
