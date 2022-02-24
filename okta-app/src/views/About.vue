<template>
  <div id="app2">
    <nav>
      <div>
        <router-link to="/">
          Home
        </router-link>
        <router-link to="/login" v-if="!authenticated">
          Login
        </router-link>
        <router-link to="/profile" v-if="authenticated" >
          Profile
        </router-link>
        <router-link to="/ordens" v-if="authenticated" >
          Ordens
        </router-link>
        <a v-if="authenticated" v-on:click="logout()">
          Logout
        </a>
      </div>
    </nav>
    <div id="content">
      <router-view/>
    </div>
  </div>

      this.claims = await Object.entries(await this.$auth.getUser()).map(
      (entry) => ({ claim: entry[0], value: entry[1] })



import axios from "axios";
export default {
  name: "Profile",
  data() {
    return {
      claims: [],
    };
  },
  async created() {
    this.claims = await Object.entries(await this.$auth.getUser()).map(
      (entry) => ({ claim: entry[0], value: entry[1] })
    );

    let accessToken = this.$auth.getAccessToken();
    console.log(`Authorization: Bearer ${accessToken}`);

    try {
      let response = await axios.get(`http://localhost:8081/users`, {
        headers: { Authorization: "Bearer " + accessToken },
      });

    for (var chave in response.data) {
      this.claims.push ({
        name: response.data[chave].username,
        dinheiro: "R$ "+ response.data[chave].dollar_balance
      });
    }

      console.log(response.data);
    } catch (error) {
      console.log("Ta errado isso aí");
      this.caffeineLevel = `${error}`;
    }
  },
};