<template>
  <div class="member-admin-container">
    <member-create></member-create>
    <member-read></member-read>
  </div>
</template>

<script>
import MemberCreate from "@/components/admin/member/MemberCreate.vue"
import MemberRead from "@/components/admin/member/MemberRead.vue"

export default {
  components: {
    MemberCreate,
    MemberRead
  }
}
</script>