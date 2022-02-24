<template>
  <div id="ordens">

    <div v-if="!this.$root.authenticated">
      <p>How much caffeine has your developer had today? <router-link role="button" to="/login">Log in to find out!</router-link></p>
    </div>

    <div v-if="this.$root.authenticated">
      <h1>Bem Vindo, {{claims.name}}!</h1>
      <p>
        {{this.caffeineLevel}}
      </p>
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