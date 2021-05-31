<template>
  <div>
    <b-table striped hover :items="items" :fields="fields" @row-clicked="handleClick"></b-table>
  </div>
</template>

<script>
export default {
  name: 'tableView',
  data() {

    return {
      fields: ['createdBy', 'createdDate', 'memo' ,'topicID'],
      items: []
    }
  },
  mounted() {
    var xhr = new XMLHttpRequest();
    var ref= this;
   //xhr.withCredentials = true;

    xhr.addEventListener("readystatechange", function() {
      if(this.readyState === 4) {
        console.log(this.responseText);
      }
    });
    xhr.onload = function () {
      // Request finished. Do processing here.
      console.log(xhr.response.data);
      var Data=JSON.parse(xhr.response);
      console.log(Data.data);
      //this.$set(this.items,'x',Data.data);
      ref.items=Data.data;
    };

    xhr.open("GET", "https://api-testnet.dragonglass.me/hedera/api/v1/topics?createdBy=0.0.531120");
    xhr.setRequestHeader("X-API-KEY", "83c3a21d-ccac-393c-9292-66cc1f43a011");

    xhr.send();
  },
  methods: {
    handleClick(record) {
      console.log(record);
      let id=record.topicID;
      this.$router.push({ name: `Messages`, params:{id} });
    }
  }
}
</script>