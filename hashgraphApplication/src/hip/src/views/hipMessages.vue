<template>
<div>
  <b-list-group v-for="(reasult, index) in results" :key="reasult.id">
    <b-list-group-item button>{{ index }}</b-list-group-item>
    <b-list-group-item button>{{ reasult }}</b-list-group-item>
    <b-list-group-item button disabled>{{ this.$route.params.id }}</b-list-group-item>
    <b-list-group-item button>This is a button too</b-list-group-item>
  </b-list-group>

    <b-form @submit="onSubmit" @reset="onReset" v-if="show">
      <b-form-group
          id="input-group-1"
          label="Name"
          label-for="input-1"
          >
        <b-form-input
            id="input-1"
            v-model="name"
            placeholder="Enter name"
            required
        ></b-form-input>
      </b-form-group>

      <b-form-group id="input-group-2" label="Your message:" label-for="input-2">
        <b-form-input
            id="input-2"
            v-model="message"
            placeholder="Enter message"
            required
        ></b-form-input>
      </b-form-group>
      <b-button type="submit" variant="primary">Submit</b-button>
      <b-button type="reset" variant="danger">Reset</b-button>
    </b-form>
    <b-card class="mt-3" header="Form Data Result">
      <pre class="m-0">{{ this.message }}</pre>
    </b-card>
  </div>
</template>
<script>
import {submitMessage} from '@/services/topicService'
export default {
  name: "hipMessages",
  data() {
    return {
      results: [],
      name: '',
      message: '',
      id: this.$route.params.id
    }
  },
  mounted() {
    function getMessageData(id) {
      var xhr = new XMLHttpRequest();
      var url = "https://api-testnet.dragonglass.me/hedera/api/hcs/messages?topicID=" + {id};
      //xhr.withCredentials = true;

      xhr.addEventListener("readystatechange", function () {
        if (this.readyState === 4) {
          console.log(this.responseText)
          var Data = JSON.parse(xhr.response);
          return Data.data;
        }
      });

      xhr.open("GET", url);
      xhr.setRequestHeader("X-API-KEY", "83c3a21d-ccac-393c-9292-66cc1f43a011");

      xhr.send();
      return [];
    }
    console.log(this.$router.params.id);
    this.results = getMessageData(this.$route.params.id);
  },
  methods: {
    onSubmit(event) {
      event.preventDefault()
      alert(JSON.stringify(this.message,name))
      let topicId=this.$route.params.id;

      let subMsg=submitMessage(topicId,this.message);
      console.log(subMsg);
    },
    onReset(event) {
      event.preventDefault()
      // Reset our form values
      this.message = ''
      this.name = ''

      // Trick to reset/clear native browser form validation state
      this.show = false
      this.$nextTick(() => {
        this.show = true
      })
    }
  }
}
</script>

<style scoped>

</style>