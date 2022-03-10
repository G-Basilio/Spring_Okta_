<template>
  <div id="app">
    <nav>
      <!-- desktop menu -->
      <div class="bg-green-800 bg-opacity-80">
        <div class="max-w-7xl mx-auto">
          <div class="flex justify-around">
            <img
              src="./assets/Solinftec-icon.png"
              alt="Logo"
              height="64"
              width="64"
            />
            <!-- menu -->
            <div class="flex items-center space-x-10 px-0">
              <!-- logo -->
              <span class="font-extrabold text-white">Stock-Market</span>
            </div>

            <!-- menu -->

            <div class="hidden md:flex items-center space-x-1">
              <router-link
                id="router-link"
                to="/"
                class="py-5 px-80 text-white hover:text-yellow-500 flex items-center"
              >
                <svg
                  class="w-6 h-6"
                  fill="none"
                  stroke="currentColor"
                  viewBox="0 0 24 24"
                  xmlns="http://www.w3.org/2000/svg"
                >
                  <path
                    stroke-linecap="round"
                    stroke-linejoin="round"
                    stroke-width="2"
                    d="M3 12l2-2m0 0l7-7 7 7M5 10v10a1 1 0 001 1h3m10-11l2 2m-2-2v10a1 1 0 01-1 1h-3m-6 0a1 1 0 001-1v-4a1 1 0 011-1h2a1 1 0 011 1v4a1 1 0 001 1m-6 0h6"
                  ></path>
                </svg>
                Home
              </router-link>
              <router-link
                id="router-link"
                class="py-5 px-10 text-white hover:text-yellow-500 flex items-center"
                to="/profile"
                v-if="authenticated"
              >
                <svg
                  class="w-6 h-6"
                  fill="none"
                  stroke="currentColor"
                  viewBox="0 0 24 24"
                  xmlns="http://www.w3.org/2000/svg"
                >
                  <path
                    stroke-linecap="round"
                    stroke-linejoin="round"
                    stroke-width="2"
                    d="M5.121 17.804A13.937 13.937 0 0112 16c2.5 0 4.847.655 6.879 1.804M15 10a3 3 0 11-6 0 3 3 0 016 0zm6 2a9 9 0 11-18 0 9 9 0 0118 0z"
                  ></path>
                </svg>
                Perfil
              </router-link>

              <!-- Order -->
              <router-link
                id="router-link"
                to="/ordens"
                class="py-5 px-2 text-white hover:text-yellow-500 flex items-center"
                v-if="authenticated"
                ><svg
                  class="w-6 h-6"
                  fill="none"
                  stroke="currentColor"
                  viewBox="0 0 24 24"
                  xmlns="http://www.w3.org/2000/svg"
                >
                  <path
                    stroke-linecap="round"
                    stroke-linejoin="round"
                    stroke-width="2"
                    d="M9 5H7a2 2 0 00-2 2v12a2 2 0 002 2h10a2 2 0 002-2V7a2 2 0 00-2-2h-2M9 5a2 2 0 002 2h2a2 2 0 002-2M9 5a2 2 0 012-2h2a2 2 0 012 2m-3 7h3m-3 4h3m-6-4h.01M9 16h.01"
                  ></path>
                </svg>
                Orders
              </router-link>
            </div>
            <!-- Logout -->
            <div class="hidden md:flex items-center space-x-1">
              <router-link
                id="router-link"
                to="logout"
                class="py-5 px-2 text-white hover:text-yellow-500 cursor-pointer flex items-center"
                v-if="authenticated"
                v-on:click="logout()"
                ><svg
                  class="w-6 h-6"
                  fill="none"
                  stroke="currentColor"
                  viewBox="0 0 24 24"
                  xmlns="http://www.w3.org/2000/svg"
                >
                  <path
                    stroke-linecap="round"
                    stroke-linejoin="round"
                    stroke-width="2"
                    d="M17 16l4-4m0 0l-4-4m4 4H7m6 4v1a3 3 0 01-3 3H6a3 3 0 01-3-3V7a3 3 0 013-3h4a3 3 0 013 3v1"
                  ></path>
                </svg>
                Logout
              </router-link>

              <!-- Login -->
              <router-link
                id="router-link"
                class="py-5 px-2 text-white hover:text-yellow-500 cursor-pointer flex items-center"
                to="/login"
                v-if="!authenticated"
              >
                <svg
                  class="w-6 h-6"
                  fill="none"
                  stroke="currentColor"
                  viewBox="0 0 24 24"
                  xmlns="http://www.w3.org/2000/svg"
                >
                  <path
                    stroke-linecap="round"
                    stroke-linejoin="round"
                    stroke-width="2"
                    d="M11 16l-4-4m0 0l4-4m-4 4h14m-5 4v1a3 3 0 01-3 3H6a3 3 0 01-3-3V7a3 3 0 013-3h7a3 3 0 013 3v1"
                  ></path>
                </svg>
                Login
              </router-link>
            </div>
            <!-- button show mobile menu -->
          </div>
        </div>
      </div>

      <!-- mobile menu -->
      <div class="" v-show="showMobileMenu">
        <router-link to="/">Home </router-link>
        <router-link to="/login" v-if="!authenticated">Login </router-link>
        <router-link to="/profile" v-if="authenticated">Profile </router-link>
        <router-link to="/ordens">Ordens </router-link>
        <a to="/logout" v-if="authenticated" v-on:click="logout()">Logout </a>
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
#router-link {
  text-decoration: none !important;
}
</style>
