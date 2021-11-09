/* storeDetailPage */
import { SET_ON_MODAL } from "./common.js";
import { SET_ORDER_FORM } from "./order.js";

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

/* 매장 상세 페이지 */
export const TOGGLE_INTEREST_BOX_STORE_DETAIL_PAGE =
  "TOGGLE_INTEREST_BOX_STORE_DETAIL_PAGE";
// 메뉴 선택 탭
export const OPEN_MENU_SELECT_MODAL = "OPEN_MENU_SELECT_MODAL";
export const SET_SELECTED_PRODUCT_BASIC_INFO =
  "SET_SELECTED_PRODUCT_BASIC_INFO";

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

    /* 매장 상세 페이지 */
    // 상단 매장 정보 영역
    storeSimpleInfo: {
      idx: 3,
      name: "KFC 부평시장역점",
      isInterested: false,
      starAverage: 4.8,
      minOrderPrice: 15000,
      notice: `이벤트 진행중! 자세한 내용은 [ 주막 소개 ] 공지를 참고하세요!`,
      image: {
        logoImg: require("@/assets/images/member_profile-img2.png"),
        representativeImg: require("@/assets/images/detail-page_representative-img.png"),
      },
    },
    // 메뉴 선택 탭
    products: {
      idx: 3,
      name: "KFC 부평시장역점",
      allProducts: [
        {
          groupIdx: 1,
          groupName: "박스",
          products: [
            {
              storeIdx: 3,
              groupIdx: 1,
              productIdx: 1,
              img: require("@/assets/images/detail-page_imgs/detail-page_food_box1.png"),
              name: "블랙라벨폴인치즈버거 박스",
              price: 11800,
            },
            {
              storeIdx: 3,
              groupIdx: 1,
              productIdx: 2,
              img: require("@/assets/images/detail-page_imgs/detail-page_food_box2.png"),
              name: "핫통삼겹베이컨버거 박스",
              price: 11500,
            },
            {
              storeIdx: 3,
              groupIdx: 1,
              productIdx: 3,
              img: require("@/assets/images/detail-page_imgs/detail-page_food_box3.png"),
              name: "징거더블다운맥스 박스",
              price: 11200,
            },
          ],
        },
        {
          groupIdx: 2,
          groupName: "세트",
          products: [
            {
              storeIdx: 3,
              groupIdx: 2,
              productIdx: 1,
              img: require("@/assets/images/detail-page_imgs/detail-page_food_set1.png"),
              name: "베스트치킨버켓팩",
              price: 23900,
            },
            {
              storeIdx: 3,
              groupIdx: 2,
              productIdx: 2,
              img: require("@/assets/images/detail-page_imgs/detail-page_food_set2.png"),
              name: "베스트셀러팩",
              price: 22900,
            },
            {
              storeIdx: 3,
              groupIdx: 2,
              productIdx: 3,
              img: require("@/assets/images/detail-page_imgs/detail-page_food_set3.png"),
              name: "뉴스타팩",
              price: 21900,
            },
            {
              storeIdx: 3,
              groupIdx: 2,
              productIdx: 4,
              img: require("@/assets/images/detail-page_imgs/detail-page_food_set4.png"),
              name: "베스트혼닭팩",
              price: 11900,
            },
          ],
        },
        {
          groupIdx: 3,
          groupName: "치킨",
          products: [],
        },
        {
          groupIdx: 4,
          groupName: "버거",
          products: [],
        },
        {
          groupIdx: 5,
          groupName: "인기",
          products: [],
        },
        {
          groupIdx: 6,
          groupName: "음료",
          products: [],
        },
        {
          groupIdx: 7,
          groupName: "스낵 & 사이드",
          products: [],
        },
        {
          groupIdx: 8,
          groupName: "요일할인",
          products: [],
        },
      ],
    },

    selectedProductBasicInfo: {
      storeIdx: 0,
      groupIdx: 0,
      productIdx: 0,
      img: "",
      imgAlt: "",
      name: "",
      detailInfo: ``,
      price: 0,
      options: {
        singleOptionGroup: [],
        multiOptionGroup: [],
      },
    },

    // 매장 소개 탭
    // 리뷰 탭
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

    /* 매장 상세 페이지 */
    [TOGGLE_INTEREST_BOX_STORE_DETAIL_PAGE](state) {
      state.storeSimpleInfo.isInterested = state.storeSimpleInfo.isInterested
        ? false
        : true;
    },
    // 메뉴 선택 탭
    [SET_SELECTED_PRODUCT_BASIC_INFO](state, productObj) {
      state.selectedProductBasicInfo = productObj;
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

    /* 매장 상세 페이지 */
    [TOGGLE_INTEREST_BOX_STORE_DETAIL_PAGE]({ commit }) {
      // axios 비동기 로직 추가 예정 ( * isInterested 변화 )
      commit(TOGGLE_INTEREST_BOX_STORE_DETAIL_PAGE);
    },
    // 메뉴 선택 탭
    [OPEN_MENU_SELECT_MODAL]({ commit }, productObj) {
      const { storeIdx, groupIdx, productIdx, img, name, price } = productObj;
      let selectedProductBasicInfo;
      let orderForm;
      // Axios 로직 ...
      // 임시 ( * Axios 대신 )
      selectedProductBasicInfo = {
        storeIdx: storeIdx,
        groupIdx: groupIdx,
        productIdx: productIdx,
        img: img,
        imgAlt: name,
        name: name,
        detailInfo: `${name}에 대한 상세 설명입니다.
        Axios로 데이터를 받아올 예정입니다.
        Axios로 데이터를 받아올 예정입니다.
        Axios로 데이터를 받아올 예정입니다.
        Axios로 데이터를 받아올 예정입니다.`,
        price: price,
      };
      // modal form 제작 ( * for 주문 or 장바구니 )
      orderForm = {
        storeIdx: storeIdx,
        groupIdx: groupIdx,
        productIdx: productIdx,
        name: name,
        price: price,
        options: {
          singleOptionGroup: [
            {
              optionGroupIdx: 1,
              optionGroupName: "감자튀김 사이즈",
              selectedOptionIdx: 1,
              optionList: [
                {
                  optionIdx: 1,
                  optionName: "M (미디움)",
                  price: 0,
                },
                {
                  optionIdx: 2,
                  optionName: "L (라지)",
                  price: 500,
                },
              ],
            },
            {
              optionGroupIdx: 2,
              optionGroupName: "음료 변경",
              selectedOptionIdx: 1,
              optionList: [
                {
                  optionIdx: 1,
                  optionName: "코카콜라",
                  price: 0,
                },
                {
                  optionIdx: 2,
                  optionName: "스프라이트",
                  price: 500,
                },
                {
                  optionIdx: 3,
                  optionName: "환타 오렌지",
                  price: 1000,
                },
              ],
            },
          ],
          multiOptionGroup: [
            {
              optionGroupIdx: 1,
              optionGroupName: "감자튀김 시즈닝",
              optionList: [
                {
                  optionIdx: 1,
                  optionName: "뿌링클",
                  price: 500,
                  onSelected: false,
                },
                {
                  optionIdx: 2,
                  optionName: "핫 시즈닝",
                  price: 500,
                  onSelected: false,
                },
                {
                  optionIdx: 3,
                  optionName: "바베큐 시즈닝",
                  price: 1000,
                  onSelected: false,
                },
              ],
            },
            {
              optionGroupIdx: 2,
              optionGroupName: "패티 옵션",
              optionList: [
                {
                  optionIdx: 1,
                  optionName: "양상추 빼기",
                  price: 0,
                  onSelected: false,
                },
                {
                  optionIdx: 2,
                  optionName: "토마토 빼기",
                  price: 0,
                  onSelected: false,
                },
                {
                  optionIdx: 3,
                  optionName: "치즈 추가",
                  price: 500,
                  onSelected: false,
                },
                {
                  optionIdx: 4,
                  optionName: "베이컨 추가",
                  price: 1000,
                  onSelected: false,
                },
                {
                  optionIdx: 5,
                  optionName: "고기 패티 추가",
                  price: 1000,
                  onSelected: false,
                },
                {
                  optionIdx: 6,
                  optionName: "치킨 패티 추가",
                  price: 1500,
                  onSelected: false,
                },
              ],
            },
          ],
        },
        numberOfProduct: 1,
      };
      // Axios 콜백 로직 start
      commit(SET_SELECTED_PRODUCT_BASIC_INFO, selectedProductBasicInfo);
      commit(`order/${SET_ORDER_FORM}`, orderForm, { root: true });
      // Axios 콜백 로직 end

      // open modal
      commit(`common/${SET_ON_MODAL}`, true, { root: true });
    },
  },
};
