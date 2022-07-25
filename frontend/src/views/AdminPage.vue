<template>
  <div>
    <AdminGnb />
    <AdminLnb />
    <main id="admin-main">
      <router-view></router-view>
    </main>
  </div>
</template>

<script>
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