<template>
  <div id="profile">
    <div class="flex flex-col">
      <div class="-my-2 overflow-x-auto sm:-mx-6 lg:-mx-8">
        <div class="py-2 align-middle inline-block min-w-full sm:px-6 lg:px-8">
          <div
            class="shadow overflow-hidden border-b border-black sm:rounded-lg"
          >
            <table class="min-w-full divide-y divide-black">
              <thead class="bg-teal-dark">
                <th
                  scope="col"
                  class="px-6 py-3 text-center text-xs font- text-white uppercase tracking-wider"
                >
                  Nome
                </th>
                <th
                  scope="col"
                  class="px-6 py-3 text-center text-xs font- text-white uppercase tracking-wider"
                >
                  Email
                </th>
                <th
                  scope="col"
                  class="px-6 py-3 text-center text-xs font- text-white uppercase tracking-wider"
                >
                  País
                </th>
                <th
                  scope="col"
                  class="px-6 py-3 text-center text-xs font- text-white uppercase tracking-wider"
                >
                  Dinheiro
                </th>
              </thead>
              <tbody
              class="bg-teal-lightest divide-y divide-black"
              v-for="(peoples, i) in people"
              :key="i"
            >
                <td class="px-3 py-4 whitespace-nowrap">
                  <div class="flex items-center">
                    <div class="ml-4">
                      <div class="text-sm font medium text-black">
                        {{ peoples.name }}
                      </div>
                    </div>
                  </div>
                </td>
                <td class="px-3 py-4 whitespace-nowrap">
                  <div class="flex items-center">
                    <div class="ml-4">
                      <div class="text-sm font medium text-black">
                        {{ peoples.email }}
                      </div>
                    </div>
                  </div>
                </td>
                <td class="px-3 py-4 whitespace-nowrap">
                  <div class="flex items-center">
                    <div class="ml-4">
                      <div class="text-sm font medium text-black">
                        {{ peoples.pais }}
                      </div>
                    </div>
                  </div>
                </td>
                <td class="px-3 py-4 whitespace-nowrap">
                  <div class="flex items-center">
                    <div class="ml-4">
                      <div class="text-sm font medium text-black">
                        {{ peoples.dinheiro }}
                      </div>
                    </div>
                  </div>
                </td>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
export default {
  data: () => ({
    people: [],
    infosUser: []
  }),
  async created() {
    this.config();
  },
  
  methods: {
    async config() {
      if (this.$root.authenticated) {
        this.claims = await this.$auth.getUser();
        let accessToken = this.$auth.getAccessToken();
        
        let response = await axios.get(    
          `http://localhost:8081/users/${this.claims.email}`, {
        headers: { Authorization: "Bearer " + accessToken },
          });

        this.infosUser = response;
        console.log(response);

        this.people.push({
          name: this.claims.name,
          email: this.claims.email,
          pais: this.claims.locale,
          dinheiro: "R$ " + response.data.dollar_balance.toFixed(2)
        });
      }
        
    }
  }
}
</script>
