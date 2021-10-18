// common
export const SET_CURRENT_PAGE = "SET_CURRENT_PAGE";
export const SET_ON_MODAL = "SET_ON_MODAL";

// homePage
export const TOGGLE_ON_HOME = "TOGGLE_ON_HOME";
export const SET_ON_HOME = "SET_ON_HOME";
export const SET_CURRENT_HOME_COORDS = "SET_CURRENT_HOME_COORDS";

// storeListPage
export const SET_ON_PREVIEW_BOX = "SET_ON_PREVIEW_BOX";
export const SET_PREVIEW_TAB = "SET_PREVIEW_TAB";
export const TOGGLE_ON_CHOOSE_FILTER = "TOGGLE_ON_CHOOSE_FILTER";
export const SET_SELECTED_SEARCH_FILTER = "SET_SELECTED_SEARCH_FILTER";

export const common = {
  namespaced: true,
  state: () => ({
    // common
    onLogin: false,
    currentPage: "homePage",
    onModal: false,

    // homePage
    onHome: false,
    currentHomeCoords: "morning",

    // storeListPage
    onPreviewBox: true,
    previewTab: "info",
    onChooseFilter: false,
    selectedSearchFilter: { text: "주막 추천순", name: "recommendOrder" },
    searchFilters: [
      { text: "주막 추천순", name: "recommendOrder" },
      { text: "별점순", name: "starOrder" },
      { text: "조회순", name: "clickOrder" },
      { text: "거리순", name: "distanceOrder" },
      { text: "빠른 배달순", name: "quickOrder" },
      { text: "주문 많은순", name: "mostOrder" },
    ],
  }),
  getters: {},
  mutations: {
    // common
    [SET_CURRENT_PAGE](state, pageName) {
      state.currentPage = pageName;
    },
    [SET_ON_MODAL](state, boolean) {
      state.onModal = boolean;
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
    [TOGGLE_ON_CHOOSE_FILTER](state) {
      state.onChooseFilter = state.onChooseFilter === true ? false : true;
    },
    [SET_SELECTED_SEARCH_FILTER](state, selectedFilter) {
      state.selectedSearchFilter = selectedFilter;
    },
  },
  actions: {
    // common
    [SET_CURRENT_PAGE]({ commit }, pageName) {
      commit(`${SET_CURRENT_PAGE}`, pageName);
    },
    [TOGGLE_ON_CHOOSE_FILTER]({ commit }) {
      commit(`${TOGGLE_ON_CHOOSE_FILTER}`);
    },
  },
};
