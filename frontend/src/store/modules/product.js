export const SET_CURRENT_CATEGORY = "SET_CURRENT_CATEGORY";
/* 매장 리스트 페이지 */
// store preview
// 홈 탭
export const SET_PREVIEW_HOME = "SET_PREVIEW_HOME";
export const TOGGLE_INTEREST_BOX = "TOGGLE_INTEREST_BOX";

// 리뷰 탭
export const SET_PREVIEW_REVIEW_ORDER = "SET_PREVIEW_REVIEW_ORDER";
export const TOGGLE_PREVIEW_LIKE_BTN = "TOGGLE_PREVIEW_LIKE_BTN";
export const TOGGLE_PREVIEW_HATE_BTN = "TOGGLE_PREVIEW_HATE_BTN";
export const PLUS_OR_MINUS_PREVIEW_LIKE = "PLUS_OR_MINUS_PREVIEW_LIKE";
export const PLUS_OR_MINUS_PREVIEW_HATE = "PLUS_OR_MINUS_PREVIEW_HATE";
export const CLICK_PREVIEW_LIKE_BTN = "CLICK_PREVIEW_LIKE_BTN";
export const CLICK_PREVIEW_HATE_BTN = "CLICK_PREVIEW_HATE_BTN";

// pagination
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
        numberOfReview: 27132,
        numberOfOwnerReview: 1572,
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
    // 홈 탭
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
    // 리뷰 탭
    previewReview: {
      idx: 1, // 매장에 대한 idx
      name: "동대문 엽기 떡볶이 - 부평점",
      order: "newest",
      reviews: [
        {
          idx: 1, // 리뷰에 대한 idx
          memberNick: "Sonny_7",
          memberImg: require("@/assets/images/member_profile-img.png"),
          date: "2021-09-27",
          star: 4.5,
          pictures: [
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
          ],
          reviewText: `부평점 엽기떡볶이는 다른 지점에 비해 맵기가 조금 덜한 것 같았어요.
          매운 맛 시켰는데 다른 지점 보통 맛보다 조금 매운 정도..??
          그래도 방문포장 했는데 사장님은 정말 친절하시더라구요!`,
          like: 27,
          onLike: false,
          hate: 6,
          onHate: false,
          comment: 9,
        },
        {
          idx: 2, // 리뷰에 대한 idx
          memberNick: "옆집사장",
          memberImg: require("@/assets/images/member_profile-img2.png"),
          date: "2021-09-25",
          star: 5.0,
          pictures: [],
          reviewText: `치킨이랑 같이 먹으면 맛있을 것 같아요
          중독되는 맛이네요 정말 맛있습니다 ^^
          KFC도 많이 사랑해주세요
          또 무슨 말을 써야 하나`,
          like: 1,
          onLike: false,
          hate: 0,
          onHate: false,
          comment: 2,
        },
      ],
    },

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
    // 홈 탭
    [SET_PREVIEW_HOME](state, obj) {
      state.previewHome = obj;
    },
    [TOGGLE_INTEREST_BOX](state) {
      state.previewHome.isInterested = state.previewHome.isInterested
        ? false
        : true;
    },
    // 리뷰 탭
    [SET_PREVIEW_REVIEW_ORDER](state, pageName) {
      state.previewReview.order = pageName;
    },
    [TOGGLE_PREVIEW_LIKE_BTN](state, reviewIdx) {
      const reviews = state.previewReview.reviews;
      for (let i = 0; i < reviews.length; i++) {
        if (reviews[i].idx === reviewIdx) {
          reviews[i].onLike = reviews[i].onLike ? false : true;
          break;
        }
      }
    },
    [TOGGLE_PREVIEW_HATE_BTN](state, reviewIdx) {
      const reviews = state.previewReview.reviews;
      for (let i = 0; i < reviews.length; i++) {
        if (reviews[i].idx === reviewIdx) {
          reviews[i].onHate = reviews[i].onHate ? false : true;
          break;
        }
      }
    },
    [PLUS_OR_MINUS_PREVIEW_LIKE](state, reviewIdx) {
      const reviews = state.previewReview.reviews;
      for (let i = 0; i < reviews.length; i++) {
        if (reviews[i].idx === reviewIdx) {
          if (!reviews[i].onLike) {
            reviews[i].like++;
          } else {
            if (reviews.like === 0) return;
            reviews[i].like--;
          }
          break;
        }
      }
    },
    [PLUS_OR_MINUS_PREVIEW_HATE](state, reviewIdx) {
      const reviews = state.previewReview.reviews;
      for (let i = 0; i < reviews.length; i++) {
        if (reviews[i].idx === reviewIdx) {
          if (!reviews[i].onHate) {
            reviews[i].hate++;
          } else {
            if (reviews[i].hate === 0) return;
            reviews[i].hate--;
          }
          break;
        }
      }
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
    // store preview
    // 홈 탭
    [SET_PREVIEW_HOME]({ commit }, obj) {
      commit(`${SET_PREVIEW_HOME}`, obj);
    },
    [TOGGLE_INTEREST_BOX]({ commit }) {
      // axios 비동기 로직 추가 예정 ( * isInterested 변화 )
      commit(`${TOGGLE_INTEREST_BOX}`);
    },
    // 리뷰 탭
    [SET_PREVIEW_REVIEW_ORDER]({ commit }, orderName) {
      // axios 비동기 로직 추가 예정 ( * 선택 순서에 따른 리뷰들 요청 )
      commit(SET_PREVIEW_REVIEW_ORDER, orderName);
    },
    [CLICK_PREVIEW_LIKE_BTN]({ commit, state, dispatch }, reviewIdx) {
      // axios 비동기 로직 추가 예정 ( * onLike, like 수 변화 요청 )

      // 비공감 btn 처리
      const reviews = state.previewReview.reviews;
      for (let i = 0; i < reviews.length; i++) {
        if (reviews[i].idx === reviewIdx) {
          if (reviews[i].onHate) {
            dispatch(CLICK_PREVIEW_HATE_BTN, reviewIdx);
            break;
          }
        }
      }

      // 공감 btn 처리
      commit(PLUS_OR_MINUS_PREVIEW_LIKE, reviewIdx);
      commit(TOGGLE_PREVIEW_LIKE_BTN, reviewIdx);
    },
    [CLICK_PREVIEW_HATE_BTN]({ commit, state, dispatch }, reviewIdx) {
      // axios 비동기 로직 추가 예정 ( * onHate, hate 수 변화 요청 )

      // 공감 btn 처리
      const reviews = state.previewReview.reviews;
      for (let i = 0; i < reviews.length; i++) {
        if (reviews[i].idx === reviewIdx) {
          if (reviews[i].onLike) {
            dispatch(CLICK_PREVIEW_LIKE_BTN, reviewIdx);
            break;
          }
        }
      }

      // 비공감 btn 처리
      commit(PLUS_OR_MINUS_PREVIEW_HATE, reviewIdx);
      commit(TOGGLE_PREVIEW_HATE_BTN, reviewIdx);
    },
  },
};
