<template>
  <div id="ordens">

    <div v-if="!this.$root.authenticated">
      <p> </p>
    </div>

    <div v-if="this.$root.authenticated">
    <h5 class="py-16 text-5xl font-semibold flex justify-center">Bem Vindo, {{claims.name}}!</h5>

    </div>
  </div>
</template>

<script>

import axios from 'axios';

export default {
  name: 'orders',
  data: function () {
    return {
      claims: '',
      caffeineLevel: ''
    }
  },
  created () { this.setup() },
  methods: {
    async setup () {
      if (this.$root.authenticated) {
        this.claims = await this.$auth.getUser()
        let accessToken = this.$auth.getAccessToken();
        console.log(`Authorization: Bearer ${accessToken}`);
        try {
          let response = await axios.get('http://localhost:8082/howcaffeinatedami',
              { headers: {'Authorization': 'Bearer ' + accessToken } } );
          this.caffeineLevel = response.data;
        }
        catch (error) {
          this.caffeineLevel = `${error}`
        }
      }
    }
  }
}
</script>