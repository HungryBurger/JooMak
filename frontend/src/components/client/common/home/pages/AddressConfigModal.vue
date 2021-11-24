<template>
  <modal-component v-if="onModal">
    <template v-slot:header>
      <div class="no-use"></div>
    </template>
    <template v-slot:content>hihi</template>
    <template v-slot:footer>
      <div class="no-use"></div>
    </template>
  </modal-component>
</template>

<script>
import ModalComponent from "@/components/client/common/share/pages/ModalComponent.vue";
import { mapState } from "vuex";

export default {
  components: {
    ModalComponent,
  },
  computed: {
    ...mapState("common", ["onModal"]),
  },
};
</script>

<style></style>
