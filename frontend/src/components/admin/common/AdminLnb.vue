<template>
  <nav>
    <span>lnb 영역입니다</span>
    <ul>
      <li class="depth1">
        <router-link to="/admin/member/memberAdmin">
          <span>회원</span>
        </router-link>
        <div class="depth2">
          <ul>
            <li>
              <router-link to="/admin/member/memberAdmin">
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

      <li class="depth1">
        <router-link to="/admin/product/storeAdmin">
          <span>상품</span>
        </router-link>
        <div class="depth2">
          <ul>
            <li>
              <router-link to="/admin/product/storeAdmin">
                <span>매장 Mockup CRUD</span>
              </router-link>
            </li>
            <li>
              <router-link to="/admin/product/prodAdmin">
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

}
</script>

<style>

</style>