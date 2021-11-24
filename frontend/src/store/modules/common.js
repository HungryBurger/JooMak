import router from "@/router";

// common
export const SET_CURRENT_PAGE = "SET_CURRENT_PAGE";
export const SET_ON_MODAL = "SET_ON_MODAL";
export const SET_ON_ADDRESS_CONFIG_REQUEST_MODAL =
  "SET_ON_ADDRESS_CONFIG_REQUEST_MODAL";
export const OPEN_ADDRESS_CONFIG_REQUEST_MODAL =
  "OPEN_ADDRESS_CONFIG_REQUEST_MODAL";
export const CLOSE_ADDRESS_CONFIG_REQUEST_MODAL =
  "CLOSE_ADDRESS_CONFIG_REQUEST_MODAL";

// homePage
export const TOGGLE_ON_HOME = "TOGGLE_ON_HOME";
export const SET_ON_HOME = "SET_ON_HOME";
export const SET_CURRENT_HOME_COORDS = "SET_CURRENT_HOME_COORDS";
export const OPEN_ADDRESS_CONFIG_MODAL = "OPEN_ADDRESS_CONFIG_MODAL";
export const SET_ON_ADDRESS_CONFIG_MODAL = "SET_ON_ADDRESS_CONFIG_MODAL";

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
    onAddressConfigRequestModal: false,

    // homePage
    onHome: false,
    currentHomeCoords: "morning",
    onAddressConfigModal: false,

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
    [SET_ON_ADDRESS_CONFIG_REQUEST_MODAL](state, boolean) {
      state.onAddressConfigRequestModal = boolean;
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
    [SET_ON_ADDRESS_CONFIG_MODAL](state, boolean) {
      state.onAddressConfigModal = boolean;
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
    [OPEN_ADDRESS_CONFIG_REQUEST_MODAL]({ state, commit }) {
      if (state.currentPage !== "homePage") {
        commit(SET_ON_ADDRESS_CONFIG_REQUEST_MODAL, true);
      }
    },
    [CLOSE_ADDRESS_CONFIG_REQUEST_MODAL]({ state, commit }) {
      commit(SET_ON_ADDRESS_CONFIG_REQUEST_MODAL, false);
      if (state.currentPage !== "homePage") {
        router.replace("/");
      }
    },
    [OPEN_ADDRESS_CONFIG_MODAL]({ state, commit }) {
      if (state.onHome) {
        if (state.onAddressConfigRequestModal) {
          commit(SET_ON_ADDRESS_CONFIG_REQUEST_MODAL, false);
        }
        commit(SET_ON_ADDRESS_CONFIG_MODAL, true);
      } else if (!state.onHome) {
        alert("주소는 홈 화면에서 설정할 수 있습니다.");
      }
    },
  },
};
