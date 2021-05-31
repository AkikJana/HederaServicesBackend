<template>
  <div>
    <b-form @submit="onSubmit" @reset="onReset" v-if="show">
      <b-form-group
          id="input-group-1"
          label="Topic Memo:"
          label-for="input-1"
          description="Set a short publicly visible memo on the new topic and is stored with the topic. (100 bytes)"
      >
        <b-form-input
            id="input-1"
            v-model="form.memo"
            placeholder="Enter memo"
            required
        ></b-form-input>
      </b-form-group>

      <b-form-group id="input-group-2" label="Your AdminKey:" label-for="input-2">
        <b-form-input
            id="input-2"
            v-model="form.adminKey"
            placeholder="Enter AdminKey"
            required
        ></b-form-input>
      </b-form-group>
      <b-button type="submit" variant="primary">Submit</b-button>
      <b-button type="reset" variant="danger">Reset</b-button>
    </b-form>
    <b-card class="mt-3" header="Form Data Result">
      <pre class="m-0">{{ form }}</pre>
    </b-card>
  </div>
</template>

<script>
import {topicCreate} from '@/services/topicService'
export default {
  data() {
    return {
      form: {
        memo: '',
        adminKey: ''
      },
      show: true
    }
  },
  methods: {
    async onSubmit(event) {
      event.preventDefault()
      alert(JSON.stringify(this.form))
      const newTopic=await topicCreate(this.form);
      console.log(newTopic);
    },
    onReset(event) {
      event.preventDefault()
      // Reset our form values
      this.form.email = ''
      this.form.name = ''
      // Trick to reset/clear native browser form validation state
      this.show = false
      this.$nextTick(() => {
        this.show = true
      })
    }
  }
}
</script>