<template>
  <div class="createHip">
    <h1>This the create HIP page using HCS</h1>
    <topicCreateVue/>
  </div>
</template>
<script>
// @ is an alias to /src
import topicCreateVue from '@/components/topicCreateForm.vue'
export default {
  name: 'Home',
  components: {
    topicCreateVue
  }
}
</script>