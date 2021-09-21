export const SET_CURRENT_CATEGORY = "SET_CURRENT_CATEGORY";
export const ALTER_FIRST_NUMBER_OF_CURRENT_PAGE_NUM =
  "ALTER_FIRST_NUMBER_OF_CURRENT_PAGE_NUM";
export const SET_CURRENT_PAGE_NUM = "SET_CURRENT_PAGE_NUM";

export const product = {
  namespaced: true,
  state: () => ({
    /* 헤더 */
    categories: [
      { en: "korean", ko: "한식" },
      { en: "western", ko: "양식" },
      { en: "japanese", ko: "일식" },
      { en: "chinese", ko: "중식" },
      { en: "flour-based", ko: "분식" },
      { en: "jokbal", ko: "족발" },
      { en: "chicken", ko: "치킨" },
      { en: "pizza", ko: "피자" },
      { en: "burger", ko: "버거" },
      { en: "dessert", ko: "디저트/카페" },
      { en: "night-food", ko: "야식" },
    ],
    currentCategory: "",

    /* 매장 리스트 페이지 */
    recommendedTags: [
      { name: "떡볶이", idx: 1 },
      { name: "순대", idx: 2 },
      { name: "튀김", idx: 3 },
    ],
    // pagination
    totalStoreNum: 1742,
    storesPerPage: 30,
    perPage: 10,
    firstNumOfCurrentPageNum: 1,
    currentPageNum: 3,
  }),
  getters: {
    homeCategories: (state) => {
      let categories = [];
      categories = categories.concat(state.categories);
      let homeCategories = [];
      for (let i = 0; i < state.categories.length / 3; i++) {
        // 4번 반복
        let currentHomeCategories = categories.splice(0, 3);
        homeCategories.push(currentHomeCategories);
      }
      return homeCategories;
    },
  },
  mutations: {
    [SET_CURRENT_CATEGORY](state, category) {
      state.currentCategory = category;
    },
    [ALTER_FIRST_NUMBER_OF_CURRENT_PAGE_NUM](state, perPage) {
      state.firstNumOfCurrentPageNum += perPage;
    },
    [SET_CURRENT_PAGE_NUM](state, pageNum) {
      state.currentPageNum = pageNum;
    },
  },
  actions: {},
};
