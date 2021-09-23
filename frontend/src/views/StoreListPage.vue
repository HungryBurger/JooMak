<template>
  <div id="storeListPage">
    <div id="scale-box"></div>
    <store-list-page-store-preview-box></store-list-page-store-preview-box>
    <div id="store-list-page_main-wrap">
      <div id="store-list-page_main">
        <!-- <span>매장리스트 페이지입니다</span>
        <p>현재 {{ currentCategory }} 메뉴를 보고 있습니다</p>
        <div v-for="store in storesInfoByCategory" :key="store.idx">
          <router-link :to="`/store/${store.idx}`">
            <div @click="changePage('storeDetailPage', store.idx)">
              <span>{{ store.img }} </span>
              <span>{{ store.storeName }}</span>
            </div>
          </router-link>
        </div> -->
        <div id="store-list-page_main_top">
          <div id="recommendation-wrap">
            <div
              class="recommended-tag"
              v-for="tag in recommendedTags"
              :key="tag.idx"
            >
              <span>#</span>&nbsp;&nbsp;{{ tag.name }}
            </div>
          </div>
          <div id="search-chart_mini">
            <div id="search-chart_mini_left">
              <span>검색어 순위</span>&nbsp;&nbsp;<img
                src="@/assets/images/store-list-page_arrow-down-double.svg"
                alt="arrow-down-double"
              />
            </div>
            <div id="search-chart_mini_right">1. 떡볶이</div>
          </div>
          <div id="search-box-wrap">
            <form id="search-box" @submit.prevent="">
              <input
                type="text"
                :v-model="inputText"
                placeholder="검색어를 입력하세요."
              />
              <div>
                <svg
                  width="16"
                  height="16"
                  viewBox="0 0 16 16"
                  fill="#858585"
                  xmlns="http://www.w3.org/2000/svg"
                >
                  <path
                    d="M11.4351 10.0629H10.7124L10.4563 9.81589C11.3528 8.77301 11.8925 7.4191 11.8925 5.94625C11.8925 2.66209 9.23042 0 5.94625 0C2.66209 0 0 2.66209 0 5.94625C0 9.23042 2.66209 11.8925 5.94625 11.8925C7.4191 11.8925 8.77301 11.3528 9.81589 10.4563L10.0629 10.7124V11.4351L14.6369 16L16 14.6369L11.4351 10.0629ZM5.94625 10.0629C3.66838 10.0629 1.82962 8.22413 1.82962 5.94625C1.82962 3.66838 3.66838 1.82962 5.94625 1.82962C8.22413 1.82962 10.0629 3.66838 10.0629 5.94625C10.0629 8.22413 8.22413 10.0629 5.94625 10.0629Z"
                  />
                </svg>
              </div>
            </form>
            <div
              id="current-search-filter_box"
              :class="{ 'on-choose': onChooseFilter }"
              @click="onClickCurrentSearchFilterBox"
            >
              <span>{{ selectedSearchFilter.text }}</span>
              <div class="svg_wrap">
                <svg
                  width="20"
                  height="24"
                  viewBox="0 0 20 24"
                  fill="#858585"
                  xmlns="http://www.w3.org/2000/svg"
                >
                  <path d="M5.83331 10L9.99998 15L14.1666 10H5.83331Z" />
                </svg>
              </div>
              <div id="select-search-filter_wrap">
                <div
                  class="select-search-filter"
                  v-for="searchFilter in searchFilters"
                  :key="searchFilter.name"
                  :class="{
                    'current-filter':
                      selectedSearchFilter.name === searchFilter.name,
                  }"
                  @click="
                    onClickFilter({
                      text: searchFilter.text,
                      name: searchFilter.name,
                    })
                  "
                >
                  {{ searchFilter.text }}
                </div>
              </div>
            </div>
          </div>
        </div>
        <div id="store-list-page_main_middle">
          <ul></ul>
        </div>
        <div id="store-list-page_main_bottom">
          <nav aria-label="Page navigation example">
            <ul class="pagination d-flex justify-content-center">
              <!-- pagination prev btn -->
              <li
                class="page-item"
                :class="{ disabled: firstNumOfCurrentPageNum === 1 }"
              >
                <a
                  class="page-link page-link_arrow"
                  href="#"
                  aria-label="Previous"
                  @click="onClickPrevBtn"
                >
                  <span aria-hidden="true">&laquo;</span>
                </a>
              </li>
              <!-- pagination pages -->
              <li
                class="page-item"
                v-for="pageNum in getCurrentPageNums"
                :class="{ active: currentPageNum === pageNum }"
                :key="pageNum"
              >
                <a
                  class="page-link"
                  href="#"
                  @click="onClickPageNum(pageNum)"
                  >{{ pageNum }}</a
                >
              </li>
              <!-- pagination next btn -->
              <li
                class="page-item"
                :class="{
                  disabled:
                    firstNumOfCurrentPageNum === lastFirstNumOfCurrentPage,
                }"
              >
                <a
                  class="page-link page-link_arrow"
                  href="#"
                  aria-label="Next"
                  @click="onClickNextBtn"
                >
                  <span aria-hidden="true">&raquo;</span>
                </a>
              </li>
            </ul>
          </nav>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import { mapActions, mapState } from "vuex";
import {
  SET_CURRENT_PAGE,
  SET_ON_PREVIEW_BOX,
  TOGGLE_ON_CHOOSE_FILTER,
  SET_SELECTED_SEARCH_FILTER,
} from "@/store/modules/common.js";
import {
  ALTER_FIRST_NUMBER_OF_CURRENT_PAGE_NUM,
  SET_CURRENT_PAGE_NUM,
} from "@/store/modules/product.js";
import StoreListPageStorePreviewBox from "@/components/client/product/store/pages/StoreListPageStorePreviewBox.vue";

export default {
  components: {
    StoreListPageStorePreviewBox,
  },
  data() {
    return {
      inputText: "",
    };
  },
  computed: {
    ...mapState("common", [
      "currentPage",
      "onChooseFilter",
      "selectedSearchFilter",
      "searchFilters",
    ]),
    ...mapState("product", [
      "recommendedTags",
      "totalStoreNum",
      "storesPerPage",
      "perPage",
      "firstNumOfCurrentPageNum",
      "currentPageNum",
    ]),
    currentCategory() {
      return this.$route.params.food;
    },
    storesInfoByCategory() {
      let stores = [];
      let currentCategory = this.$route.params.food;
      //axios 로직 부분 ( * currentCategory 사용 )
      switch (currentCategory) {
        case "korean":
          stores = [
            {
              idx: 1,
              storeName: "형진이 뚝배기",
              img: "이미지 1",
            },
            {
              idx: 2,
              storeName: "경호네 순대국",
              img: "이미지 2",
            },
          ];
          break;
        case "western":
          stores = [
            {
              idx: 1,
              storeName: "형진이네 스파게티",
              img: "이미지 1",
            },
            {
              idx: 2,
              storeName: "경호네 스테이크",
              img: "이미지 2",
            },
          ];
          break;
      }

      return stores;
    },
    getNumberOfPageByTotalStoreNum() {
      const numberOfPage =
        Math.floor(this.totalStoreNum / this.storesPerPage) + 1;
      return numberOfPage;
    },
    getCurrentPageNums() {
      const currentPageNums = [];
      for (
        let i = this.firstNumOfCurrentPageNum;
        i < this.firstNumOfCurrentPageNum + this.perPage;
        i++
      ) {
        currentPageNums.push(i);
        if (i === this.getNumberOfPageByTotalStoreNum) break;
      }

      return currentPageNums;
    },
    lastFirstNumOfCurrentPage() {
      const lastFirstNum =
        this.getNumberOfPageByTotalStoreNum -
        (this.getNumberOfPageByTotalStoreNum % this.perPage) +
        1;
      return lastFirstNum;
    },
  },
  methods: {
    ...mapActions("common", [`${TOGGLE_ON_CHOOSE_FILTER}`]),
    changePage(pageName, idx) {
      this.$store.commit(`common/${SET_CURRENT_PAGE}`, pageName);
      this.read(idx);
    },
    read(idx) {
      axios
        .get("https://reqres.in/api/users?page=" + idx)
        .then((res) => {
          console.log("매장리스트 페이지(미리보기창 용) axios 통신 성공");
          console.log(res.data.data);
        })
        .catch((err) => {
          cosonle.log(err);
        });
    },
    onClickFilter(selectedFilterObj) {
      this.$store.commit(
        `common/${SET_SELECTED_SEARCH_FILTER}`,
        selectedFilterObj
      );
    },
    onClickCurrentSearchFilterBox() {
      // filter 선택모드 끄기
      console.log(this.onChooseFilter);
      if (this.onChooseFilter) {
        const filterWrap = document.querySelector("#select-search-filter_wrap");
        const filters = document.querySelectorAll(".select-search-filter");
        filters.forEach((filterDiv) => {
          filterDiv.style.transform = `translateY(${document.body.offsetHeight *
            0.055 *
            this.searchFilters.length *
            -1}px)`;
        });
        filterWrap.style.height = 0;
        setTimeout(() => {
          this.TOGGLE_ON_CHOOSE_FILTER();
        }, 250);
      }
      // filter 선택모드 켜기
      else {
        this.TOGGLE_ON_CHOOSE_FILTER();
        const filterWrap = document.querySelector("#select-search-filter_wrap");
        const filters = document.querySelectorAll(".select-search-filter");
        filterWrap.style.height = "600%";
        filters.forEach((filterDiv) => {
          filterDiv.style.transform = `translateY(0px)`;
        });
      }
    },
    onClickPrevBtn() {
      if (this.firstNumOfCurrentPageNum !== 1) {
        this.$store.commit(
          `product/${ALTER_FIRST_NUMBER_OF_CURRENT_PAGE_NUM}`,
          -this.perPage
        );
      }
    },
    onClickNextBtn() {
      if (this.firstNumOfCurrentPageNum !== this.lastFirstNumOfCurrentPage) {
        this.$store.commit(
          `product/${ALTER_FIRST_NUMBER_OF_CURRENT_PAGE_NUM}`,
          this.perPage
        );
      }
    },
    onClickPageNum(pageNum) {
      this.$store.commit(`product/${SET_CURRENT_PAGE_NUM}`, pageNum);
    },
  },
  created() {
    // 미리보기 창 켜기
    this.$store.commit(`common/${SET_ON_PREVIEW_BOX}`, true);

    // axios로 첫 페이지 매장 정보 불러오기
    // axios
    //   .get("https://reqres.in/api/users?page=" + idx)
    //   .then((res) => {
    //     console.log(res.data.data);
    //     this.totalStoreNum = res.data.totalStoreNum;

    //   })
    //   .catch((err) => {
    //     cosonle.log(err);
    //   });
  },
  mounted() {
    console.log("총 페이지 수 : " + this.getNumberOfPageByTotalStoreNum);
    console.log("마지막 첫 번째 번호" + this.lastFirstNumOfCurrentPage);
  },
};
</script>

<style scoped>
#storeListPage {
  position: relative;
  right: 28%;
  overflow: hidden;
  display: flex;
  width: 128%;
  height: 88vh;
}
#scale-box {
  transition: all 0.7s;
  width: 28%;
  height: 100%;
  background-color: blue;
}

#store-list-page_main-wrap {
  display: flex;
  justify-content: center;
  transition: all 0.7s;
  width: 72%;
  height: 100%;
  background-color: #fff0b1;
}
#store-list-page_main {
  box-sizing: border-box;
  padding: 0 3vw;
  padding-top: 2vh;
  padding-bottom: 2vh;
  display: flex;
  flex-direction: column;
  transition: all 0.7s;
  width: 100%;
  height: 100%;
  background-color: white;
}
#store-list-page_main_top {
  display: flex;
  justify-content: space-between;
  align-items: center;
  box-sizing: border-box;
  width: 100%;
  height: 11%;
}
#store-list-page_main_top > div {
  width: 33.3%;
  height: 5.5vh;
}
#recommendation-wrap {
  box-sizing: border-box;
  padding-right: 4%;
  display: flex;
  gap: 5%;
  justify-content: space-between;
  align-items: center;
}
.recommended-tag {
  cursor: pointer;
  transition: 0.4s;
  color: #858585;
  font-size: 12px;
  display: flex;
  justify-content: center;
  align-items: center;
  width: 30%;
  height: 100%;
  border: 1px solid #ffdd1b;
  border-radius: 10px;
}
.recommended-tag > span {
  transition: 0.4s;
  font-size: 10px;
  color: #ffdd1b;
}
.recommended-tag:hover {
  background-color: #ffdd1b;
  color: white;
  font-weight: bold;
}
.recommended-tag:hover > span {
  color: white;
}
#search-chart_mini {
  display: flex;
  justify-content: center;
  align-items: center;
  cursor: pointer;
  border: 1px solid #ffc463;
  border-radius: 10px;
}
#search-chart_mini > div {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 50%;
  height: calc(100% + 2px);
}
#search-chart_mini_left {
  border: 1px solid #ffc463;
  border-top-left-radius: 10px;
  border-bottom-left-radius: 10px;
  background-color: #ffc463;
  color: white;
  transform: translateX(-1px);
}
#search-chart_mini_left > span {
  font-size: 12px;
}
#search-chart_mini_left > img {
  position: relative;
  top: 0.5%;
  height: 27%;
  width: auto;
}
#search-chart_mini_right {
  font-size: 12px;
}

#search-box-wrap {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding-left: 4%;
}
#search-box-wrap > div {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100%;
}
#search-box {
  display: flex;
  width: 58%;
  height: 100%;
  border: 1px solid #ffdd1b;
  border-radius: 10px;
}
#search-box > input {
  width: 85%;
  padding: 0;
  box-sizing: border-box;
  padding-left: 1vw;
  font-size: 12px;
  border: none;
  border-radius: 10px;
}
#search-box > input:focus {
  outline: none;
}
#search-box > div {
  cursor: pointer;
  display: flex;
  justify-content: center;
  align-items: center;
  width: 15%;
  height: 100%;
}
#search-box > div:hover svg {
  fill: #292929;
}
#search-box > div > svg {
  width: 60%;
  height: auto;
}
#current-search-filter_box {
  transition: 0.7s;
  cursor: pointer;
  position: relative;
  width: 36%;
  border: 1px solid #ffdd1b;
  border-radius: 10px;
}
#current-search-filter_box.on-choose {
  border-bottom-left-radius: 0;
  border-bottom-right-radius: 0;
}
#current-search-filter_box > span {
  position: absolute;
  left: 0;
  font-size: 12px;
  padding-left: 10%;
}
.svg_wrap {
  position: absolute;
  right: 0;
  display: flex;
  justify-content: center;
  align-items: center;
}
.svg_wrap > svg {
  width: 80%;
}
#select-search-filter_wrap {
  overflow: hidden;
  transition: 0.7s;
  position: absolute;
  top: calc(100% + 1px);
  right: -1px;
  width: calc(100% + 2px);
  height: 0;
  /* height: 600%; */
  border-bottom-left-radius: 10px;
  border-bottom-right-radius: 10px;
}
.select-search-filter {
  transition: 0.7s;
  font-size: 12px;
  box-sizing: border-box;
  padding-left: 10%;
  background: white;
  display: flex;
  align-items: center;
  border: 1px solid #ffdd1b;
  border-top: none;
  width: 100%;
  height: 5.5vh;
  transform: translateY(calc(5.5vh * -6));
}
.select-search-filter:hover {
  background-color: #ffdd1b;
  color: white;
}
.select-search-filter:last-child {
  border-bottom-left-radius: 10px;
  border-bottom-right-radius: 10px;
}
.select-search-filter.current-filter {
  background-color: #ffdd1b;
  color: white;
}

#store-list-page_main_middle {
  box-sizing: border-box;
  width: 100%;
  height: 81%;
  background-color: burlywood;
}
#store-list-page_main_bottom {
  display: flex;
  justify-content: center;
  width: 100%;
  height: 8%;
}
#store-list-page_main ul {
  margin: 0;
}
#store-list-page_main nav,
#store-list-page_main ul,
#store-list-page_main li {
  height: 100%;
}
#store-list-page_main li {
  display: flex;
  align-items: flex-end;
}
#store-list-page_main li > a {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 40%;
}

#store-list-page_main .page-link {
  box-sizing: content-box;
  width: 1.6vw;
  text-align: center;
}
#store-list-page_main .page-link:hover {
  background-color: #fcfabe;
  color: #292929;
}
#store-list-page_main .page-link:focus {
  background-color: white;
  box-shadow: 0 0 0 0.25rem rgb(253 235 13 / 25%);
  color: white;
}
#store-list-page_main .page-link_arrow:focus {
  color: #292929;
}

#store-list-page_main .page-item.active .page-link {
  background-color: #ffdd1b;
  border-color: #ffdd1b;
}
#store-list-page_main .page-item.active .page-link:focus {
  border-color: white;
}
.page-link {
  -webkit-touch-callout: none;
  -webkit-user-select: none;
  -khtml-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
  user-select: none;
}
</style>
