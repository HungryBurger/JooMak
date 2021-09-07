export const SET_CURRENT_CATEGORY = "SET_CURRENT_CATEGORY";

export const product = {
  namespaced: true,
  state: () => ({
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
  }),
  getters: {},
  mutations: {
    [SET_CURRENT_CATEGORY](state, category) {
      state.currentCategory = category;
    },
  },
  actions: {},
};
