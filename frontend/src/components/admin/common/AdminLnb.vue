<template>
  <nav id="admin-lnb">
    <ul class="depth1">
      <li :class="{current: selectedDepth1 === 1}">
        <router-link to="/admin/member/memberAdmin" :class="{current: selectedDepth1 === 1}">
          <h5>회원</h5>
        </router-link>
        <div>
          <ul class="depth2">
            <li>
              <router-link to="/admin/member/memberAdmin" @click="onClickMenu(1)">
                <span>회원 Mockup CRUD</span>
              </router-link>
            </li>
            <!-- <li>
              <router-link>
                <span>회원 소메뉴 Tmp</span>
              </router-link>
            </li> -->
          </ul>
        </div>
      </li>

      <li :class="{current: selectedDepth1 === 2}">
        <router-link to="/admin/product/storeAdmin" :class="{current: selectedDepth1 === 2}">
          <h5>상품</h5>
        </router-link>
        <div>
          <ul class="depth2">
            <li>
              <router-link to="/admin/product/storeAdmin" @click="onClickMenu(2)">
                <span>매장 Mockup CRUD</span>
              </router-link>
            </li>
            <li>
              <router-link to="/admin/product/prodAdmin" @click="onClickMenu(2)">
                <span>메뉴 Mockup CRUD</span>
              </router-link>
            </li>
          </ul>
        </div>
      </li>
    </ul>
  </nav>
</template>

<script>
export default {
  data() {
    return {
      selectedDepth1: 0
    }
  },
  methods: {
    onClickMenu(menuNum) {
      this.selectedDepth1 = menuNum
    }
  }
}
</script>