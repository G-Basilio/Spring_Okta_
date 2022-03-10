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


<div class="bg-white px-4 py-3 flex items-center justify-between border-t border-gray-200 sm:px-6">
    <div class="flex-1 flex justify-between sm:hidden">
      <a href="#" class="relative inline-flex items-center px-4 py-2 border border-gray-300 text-sm font-medium rounded-md text-gray-700 bg-white hover:bg-gray-50"> Previous </a>
      <a href="#" class="ml-3 relative inline-flex items-center px-4 py-2 border border-gray-300 text-sm font-medium rounded-md text-gray-700 bg-white hover:bg-gray-50"> Next </a>
    </div>
    <div class="hidden sm:flex-1 sm:flex sm:items-center sm:justify-between">
      <div>
        <p class="text-sm text-gray-700">
          Showing
          {{ ' ' }}
          <span class="font-medium">1</span>
          {{ ' ' }}
          to
          {{ ' ' }}
          <span class="font-medium">10</span>
          {{ ' ' }}
          of
          {{ ' ' }}
          <span class="font-medium">97</span>
          {{ ' ' }}
          results
        </p>
      </div>
      <div>
        <nav class="relative z-0 inline-flex rounded-md shadow-sm -space-x-px" aria-label="Pagination">
          <a href="#" class="relative inline-flex items-center px-2 py-2 rounded-l-md border border-gray-300 bg-white text-sm font-medium text-gray-500 hover:bg-gray-50">
            <span class="sr-only">Previous</span>
            <ChevronLeftIcon class="h-5 w-5" aria-hidden="true" />
          </a>
          <!-- Current: "z-10 bg-indigo-50 border-indigo-500 text-indigo-600", Default: "bg-white border-gray-300 text-gray-500 hover:bg-gray-50" -->
          <a href="#" aria-current="page" class="z-10 bg-indigo-50 border-indigo-500 text-indigo-600 relative inline-flex items-center px-4 py-2 border text-sm font-medium"> 1 </a>
          <a href="#" class="bg-white border-gray-300 text-gray-500 hover:bg-gray-50 relative inline-flex items-center px-4 py-2 border text-sm font-medium"> 2 </a>
          <a href="#" class="bg-white border-gray-300 text-gray-500 hover:bg-gray-50 hidden md:inline-flex relative items-center px-4 py-2 border text-sm font-medium"> 3 </a>
          <span class="relative inline-flex items-center px-4 py-2 border border-gray-300 bg-white text-sm font-medium text-gray-700"> ... </span>
          <a href="#" class="bg-white border-gray-300 text-gray-500 hover:bg-gray-50 hidden md:inline-flex relative items-center px-4 py-2 border text-sm font-medium"> 8 </a>
          <a href="#" class="bg-white border-gray-300 text-gray-500 hover:bg-gray-50 relative inline-flex items-center px-4 py-2 border text-sm font-medium"> 9 </a>
          <a href="#" class="bg-white border-gray-300 text-gray-500 hover:bg-gray-50 relative inline-flex items-center px-4 py-2 border text-sm font-medium"> 10 </a>
          <a href="#" class="relative inline-flex items-center px-2 py-2 rounded-r-md border border-gray-300 bg-white text-sm font-medium text-gray-500 hover:bg-gray-50">
            <span class="sr-only">Next</span>
            <ChevronRightIcon class="h-5 w-5" aria-hidden="true" />
          </a>
        </nav>
      </div>
    </div>
  </div>
<!--^^^^^^^^^^^^^ -->
  <div class="flex items-center space-x-1">
    <a href="#" class="px-4 py-2 font-bold text-teal-darkest bg-teal-lightest rounded-md hover:bg-teal-darkest hover:text-white">
        Previous
    </a>

    <a href="#" class="px-4 py-2 text-teal-darkest bg-teal-lightest rounded-md hover:bg-teal-darkest hover:text-white">
        1
    </a>
    <a href="#" class="px-4 py-2 text-teal-darkest bg-teal-lightest rounded-md hover:bg-teal-darkest hover:text-white">
        2
    </a>
    <a href="#" class="px-4 py-2 text-teal-darkest bg-teal-lightest rounded-md hover:bg-teal-darkest hover:text-white">
        3
    </a>
    <a href="#" class="px-4 py-2 font-bold text-teal-darkest bg-teal-lightest rounded-md hover:bg-teal-darkest hover:text-white">
        Next
    </a>
</div>






async getMoeda() {
      console.log("to aquiiiiiiiiii");
      if (this.$root.authenticated) {
        this.claims = await this.$auth.getUser();
        let accessToken = this.$auth.getAccessToken();
        try {
          let response = await axios.get(`http://localhost:8081/stocks/todos`, {
            headers: { Authorization: "Bearer " + accessToken },
          });
          console.log(response.data);
          let balance = response.data;

          for (let key in balance) {
            if (balance[key].userStokcks.user.username === this.claims.email) {
              console.log("É igual abestadooo");
              this.teste.push = {
                username: balance[key].userStokcks.user.username,
                nome: balance[key].stock_name,
                simbolo: balance[key].stock_symbol,
                volume: balance[key].volume,

              };
            }
          }

          console.log(this.teste);
        } catch (error) {
          this.walletUser = `${error}`;
        }
      }
    },