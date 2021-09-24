export const SET_CURRENT_CATEGORY = "SET_CURRENT_CATEGORY";
export const SET_PREVIEW_HOME = "SET_PREVIEW_HOME";
export const TOGGLE_INTEREST_BOX = "TOGGLE_INTEREST_BOX";
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
    // storeList
    stores: [
      {
        idx: 1,
        name: "동대문 엽기 떡볶이 - 부평점",
        logoImg: "https://www.yupdduk.com/images/logo61.png",
        logoImgAlt: "엽기떡볶이 로고",
        starAverage: 4.8,
        minutes: 48,
        numberOfReview: 271,
        numberOfOwnerReview: 157,
      },
      {
        idx: 2,
        name: "동대문 엽기 떡볶이 - 부평점",
        logoImg: "https://www.yupdduk.com/images/logo61.png",
        logoImgAlt: "엽기떡볶이 로고",
        starAverage: 4.8,
        minutes: 72,
        numberOfReview: 271,
        numberOfOwnerReview: 157,
      },
      {
        idx: 3,
        name: "동대문 엽기 떡볶이 - 부평점",
        logoImg: "https://www.yupdduk.com/images/logo61.png",
        logoImgAlt: "엽기떡볶이 로고",
        starAverage: 4.8,
        minutes: 33,
        numberOfReview: 271,
        numberOfOwnerReview: 157,
      },
      {
        idx: 4,
        name: "동대문 엽기 떡볶이 - 부평점",
        logoImg: "https://www.yupdduk.com/images/logo61.png",
        logoImgAlt: "엽기떡볶이 로고",
        starAverage: 4.8,
        minutes: -1,
        numberOfReview: 271,
        numberOfOwnerReview: 157,
      },
      {
        idx: 5,
        name: "동대문 엽기 떡볶이 - 부평점",
        logoImg: "https://www.yupdduk.com/images/logo61.png",
        logoImgAlt: "엽기떡볶이 로고",
        starAverage: 4.8,
        minutes: 90,
        numberOfReview: 271,
        numberOfOwnerReview: 157,
      },
      {
        idx: 6,
        name: "동대문 엽기 떡볶이 - 부평점",
        logoImg: "https://www.yupdduk.com/images/logo61.png",
        logoImgAlt: "엽기떡볶이 로고",
        starAverage: 4.8,
        minutes: 32,
        numberOfReview: 271,
        numberOfOwnerReview: 157,
      },
      {
        idx: 7,
        name: "동대문 엽기 떡볶이 - 부평점",
        logoImg: "https://www.yupdduk.com/images/logo61.png",
        logoImgAlt: "엽기떡볶이 로고",
        starAverage: 4.8,
        minutes: -1,
        numberOfReview: 271,
        numberOfOwnerReview: 157,
      },
      {
        idx: 8,
        name: "동대문 엽기 떡볶이 - 부평점",
        logoImg: "https://www.yupdduk.com/images/logo61.png",
        logoImgAlt: "엽기떡볶이 로고",
        starAverage: 4.8,
        minutes: 50,
        numberOfReview: 271,
        numberOfOwnerReview: 157,
      },
      {
        idx: 9,
        name: "동대문 엽기 떡볶이 - 부평점",
        logoImg: "https://www.yupdduk.com/images/logo61.png",
        logoImgAlt: "엽기떡볶이 로고",
        starAverage: 4.8,
        minutes: 30,
        numberOfReview: 271,
        numberOfOwnerReview: 157,
      },
      {
        idx: 10,
        name: "동대문 엽기 떡볶이 - 부평점",
        logoImg: "https://www.yupdduk.com/images/logo61.png",
        logoImgAlt: "엽기떡볶이 로고",
        starAverage: 4.8,
        minutes: 92,
        numberOfReview: 271,
        numberOfOwnerReview: 157,
      },
    ],
    // store preview
    // 미리보기 창 홈 탭
    previewHome: {
      idx: 1,
      name: "동대문 엽기 떡볶이 - 부평점",
      isInterested: false,
      image: {
        logoImg: "https://www.yupdduk.com/images/logo61.png",
        logoImgAlt: "엽기떡볶이 로고",
        previewImages: [
          {
            idx: 1,
            img: require("@/assets/images/food1.jpg"),
            imgAlt: "미리보기 이미지 1",
          },
          {
            idx: 2,
            img: require("@/assets/images/food2.jpg"),
            imgAlt: "미리보기 이미지 2",
          },
          {
            idx: 3,
            img: require("@/assets/images/food3.jpg"),
            imgAlt: "미리보기 이미지 3",
          },
          {
            idx: 4,
            img: require("@/assets/images/food4.jpg"),
            imgAlt: "미리보기 이미지 4",
          },
        ],
      },
      numberOfReview: 271,
      numberOfOwnerReview: 157,
      totalOrder: 102843,
      monthOrder: 3232,
      businessHours: `월 ~ 금 : 11:00 ~ 22:00
      토 : 13:00 ~ 20:00
      일 : 정기휴무
      브레이크 : 매일 15:00 ~ 16:00`,
    },
    // 미리보기 창 리뷰 탭
    previewReview: [],

    // pagination
    totalStoreNum: 1742,
    storesPerPage: 10,
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
    /* 헤더 */
    [SET_CURRENT_CATEGORY](state, category) {
      state.currentCategory = category;
    },

    /* 매장 리스트 페이지 */
    // store preview
    [SET_PREVIEW_HOME](state, obj) {
      state.previewHome = obj;
    },
    [TOGGLE_INTEREST_BOX](state) {
      state.previewHome.isInterested = state.previewHome.isInterested
        ? false
        : true;
    },
    // pagination
    [ALTER_FIRST_NUMBER_OF_CURRENT_PAGE_NUM](state, perPage) {
      state.firstNumOfCurrentPageNum += perPage;
    },
    [SET_CURRENT_PAGE_NUM](state, pageNum) {
      state.currentPageNum = pageNum;
    },
  },
  actions: {
    /* 매장 리스트 페이지 */
    //store preview
    [SET_PREVIEW_HOME]({ commit }, obj) {
      commit(`${SET_PREVIEW_HOME}`, obj);
    },
    [TOGGLE_INTEREST_BOX]({ commit }) {
      commit(`${TOGGLE_INTEREST_BOX}`);
      // axios 로직 추가 예정
    },
  },
};
