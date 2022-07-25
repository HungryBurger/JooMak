<template>
  <div id="admin-container">
    <AdminGnb />
    <div>
      <AdminLnb />
      <main id="admin-main">
        <router-view></router-view>
      </main>
    </div>
  </div>
</template>

<script>
import "@/assets/styles/css/admin.css";
import AdminGnb from "@/components/admin/common/AdminGnb.vue";
import AdminLnb from "@/components/admin/common/AdminLnb.vue";

export default {
  components: {
    AdminGnb,
    AdminLnb
  }
}
</script>

<style>

</style>