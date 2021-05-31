<template>
  <div class="about">
    <h1>This is an about page</h1>
    <vueTable/>
  </div>
</template>
<script>
// @ is an alias to /src
import vueTable from '@/components/table.vue'
export default {
  name: 'Home',
  components: {
    vueTable
  }
}
</script>