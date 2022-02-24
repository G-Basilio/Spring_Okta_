<template>
  <div id="app">
    <nav>
      <!-- desktop menu -->
      <div class="bg-teal-darker">
        <div class="max-w-7xl mx-auto">
          <div class="flex justify-space-between">
            <img
              src="./assets/Solinftec-icon.png"
              alt="Logo"
              height="64"
              width="64"
            />
            <!-- menu -->
            <div class="flex space-x-5">
              <!-- logo -->
              <router-link to="/">
                <a class="flex items-center space-x-2 py-5 px-2">
                  <svg
                    class="w-8 h-8 text-white"
                    fill="none"
                    stroke="currentColor"
                    viewBox="0 0 24 24"
                    xmlns="http://www.w3.org/2000/svg"
                  ></svg>
                  <span class="font-extrabold text text-white">Stock-Market</span>
                </a>
              </router-link>
              <!-- menu -->

              <div class="hidden md:flex items-center space-x-1">
                <router-link
                  to="/"
                  class="py-5 px-2 text-white hover:text-teal-dark"
                  >Home
                </router-link>
                <router-link
                  class="py-5 px-2 text-white hover:text-teal-dark"
                  to="/profile"
                  v-if="authenticated"
                >
                  Profile
                </router-link>
                <router-link
                  to="/ordens"
                  class="py-5 px-2 text-white hover:text-teal-dark"
                  v-if="authenticated"
                >
                  Ordens
                </router-link>
              </div>
            </div>
            <!-- login -->
            <div class="hidden md:flex items-center space-x-1">
              <a
                class="py-5 px-2 text-white hover:text-teal-dark"
                v-if="authenticated"
                v-on:click="logout()"
              >
                Logout
              </a>
              <router-link
                class="py-5 px-2 text-white hover:text-teal-dark"
                to="/login"
                v-if="!authenticated"
              >
                Login
              </router-link>
            </div>
            <!-- button show mobile menu -->
          </div>
        </div>
      </div>

      <!-- mobile menu -->
      <div class="md:hidden bg-indigo-600" v-show="showMobileMenu">
        <router-link
          to="/"
          class="block py-2 px-4 hover:bg-indigo-700 hover:text-indigo-400 text-indigo-100"
          >Home
        </router-link>
        <router-link
          class="block py-2 px-4 hover:bg-indigo-700 hover:text-indigo-400 text-indigo-100"
          to="/login"
          v-if="!authenticated"
          >Login
        </router-link>
        <router-link
          class="block py-2 px-4 hover:bg-indigo hover:text-indigo text-indigo"
          to="/profile"
          v-if="authenticated"
          >Profile
        </router-link>

        <router-link
          to="/ordens"
          class="block py-2 px-4 hover:bg-indigo hover:text-indigo text-indigo"
          >Ordens
        </router-link>
        <a
          class="block py-2 px-4 hover:bg-indigo hover:text-indigo text-indigo"
          to="/logout"
          v-if="authenticated"
          v-on:click="logout()"
          >Logout
        </a>
      </div>
    </nav>
    <div id="content">
      <router-view />
    </div>
  </div>
</template>

<script>
import { ref } from "vue";
export default {
  name: "#app",
  data: function () {
    return { authenticated: false };
  },
  setup() {
    const showMobileMenu = ref(false);

    return { showMobileMenu };
  },
  async created() {
    await this.isAuthenticated();
    this.$auth.authStateManager.subscribe(this.isAuthenticated);
  },
  watch: {
    // Everytime the route changes, check for auth status
    $route: "isAuthenticated",
  },
  methods: {
    async isAuthenticated() {
      this.authenticated = await this.$auth.isAuthenticated();
    },
    async logout() {
      await this.$auth.signOut();
    },
  },
};
</script>

<style>
@tailwind base;
@tailwind components;
@tailwind utilities;
</style>
