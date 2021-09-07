<template>
  <div id="storeListPage">
    <span>매장리스트 페이지입니다</span>
    <p>현재 {{ currentCategory }} 메뉴를 보고 있습니다</p>
    <div v-for="store in storesInfoByCategory" :key="store.idx">
      <router-link :to="`/store/${store.idx}`">
        <div @click="changePage('storeDetailPage', store.idx)">
          <span>{{ store.img }} </span>
          <span>{{ store.storeName }}</span>
        </div>
      </router-link>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import { mapState } from "vuex";

export default {
  data() {
    return {};
  },
  computed: {
    ...mapState("common", ["currentPage"]),
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
  },
  methods: {
    changePage(pageName, idx) {
      this.$store.commit("common/setCurrentPage", pageName);
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
  },
};
</script>

<style scoped>
#storeListPage {
  width: 500px;
  height: 300px;
  background-color: thistle;
}
</style>
