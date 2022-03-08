<template>
  <div id="profile">
    <div class="flex-auto">
      <div class="-my-2 overflow-x-hidden sm:-mx-2 lg:-mx-1">
        <div class="py-20 align-middle inline-table min-w-full sm:px-32 lg:px-48">
          <div
            class="bg-green-300 bg-opacity-20 border-2 border-green-800 sm:rounded-lg"
          >
            <table class="min-w-full divide-y divide-black">
              <thead class="bg-green-600 bg-opacity-70">
                <th
                  scope="col"
                  class="px-2 py-5 text-center text-xs text-white uppercase tracking-wider"
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
                  verificação de email
                </th>
                <th
                  scope="col"
                  class="px-6 py-3 text-center text-xs font- text-white uppercase tracking-wider"
                >
                  Saldo
                </th>
              </thead>
              <tbody
              class=" divide-y divide-black"
              v-for="(peoples, i) in people"
              :key="i"
            >
              <tr class="font-extrabold">
                <td class="px-3 py-4 whitespace-nowrap ">
                  <div class="flex items justify-center">
                      <div class=" text-gray-900 ">
                        {{ peoples.name }}
                    </div>
                  </div>
                </td>
                <td class="px-3 py-4 whitespace-nowrap">
                  <div class="flex items justify-center">
                      <div class=" text-gray-900">
                        {{ peoples.email }}
                    </div>
                  </div>
                </td>
                <td class="px-3 py-4 whitespace-nowrap">
                  <div class="flex items justify-center">
                      <div class=" text-gray-900">
                        {{ peoples.verificacao }}
                    </div>
                  </div>
                </td>
                <td class="px-3 py-4 whitespace-nowrap">
                  <div class="flex items justify-center">
                      <div class=" text-gray-900">
                        {{ peoples.dinheiro }}
                    </div>
                  </div>
                </td>
                </tr>
              </tbody>
            </table>
            <table class="min-w-full divide-y divide-black">
            </table>
             <th
                  class="px-6 py-3 text-white"
                >
                  
                </th>
            <table class="min-w-full divide-y divide-black">
              <thead class="bg-green-600 bg-opacity-70">
                <th
                  scope="col"
                  class="px-6 py-3 text-center text-xs font- text-white uppercase tracking-wider"
                >
                  Simbolo
                </th>
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
                  Quantidade
                </th>
                <th
                scope="col"
                class="px-6 py-3 text-center text-xs font- text-white uppercase tracking-wider"
              ></th>
              </thead>
              <tbody
              class="divide-y divide-black"
              v-for="(balances, i) in balance"
              :key="i"
            >
              <tr class="font-extrabold">
                <td class="px-3 py-4 whitespace-nowrap ">
                  <div class="flex items justify-center">
                      <div class=" text-gray-900">
                        {{ balances.simbolo }}
                    </div>
                  </div>
                </td>
                <td class="px-3 py-4 whitespace-nowrap">
                  <div class="flex items justify-center">
                      <div class=" text-gray-900">
                        {{ balances.nome }}
                    </div>
                  </div>
                </td>
                <td class="px-3 py-4 whitespace-nowrap">
                  <div class="flex items justify-center">
                    <div class="ml-4">
                      <div class=" text-gray-900">
                        {{ balances.volume }}
                      </div>
                    </div>
                  </div>
                </td>
                  <td class="px-3 py-4 whitespace-nowrap">
                  <div class="flex items justify-center">
                    <button
                      class="bg-green-800 bg-opacity-80 hover:bg-yellow-400  text-white font-bold py-2 px-4 border-2 border-gray-800 rounded" 
                      type="button"
              v-on:click="toggleModal()"
            >
              Vender
                      
                    </button>
                  </div>
                </td>
                </tr>
                
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
    balance: [],
    infosUser: [],
    showModal: false,

  }),
  async created() {
    this.config();
    this.stockBalance();
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
          verificacao: this.claims.email_verified,
          dinheiro: "R$ " + response.data.dollar_balance.toFixed(2)
        });
      }
        
    },
    async stockBalance() {
      if (this.$root.authenticated) {
        this.claims = await this.$auth.getUser();
        let accessToken = this.$auth.getAccessToken();
        
        let response = await axios.get(    
          `http://localhost:8081/stocks/todos`, {
        headers: { Authorization: "Bearer " + accessToken },
          });
    
        console.log(response );
        for (var chave in response.data) {
        this.balance.push({
          simbolo: response.data[chave].stock_symbol,
          nome: response.data[chave].stock_name,
          volume: response.data[chave].volume
        });
      }
        
      }
    }
  },
  toggleModal: function () {
      this.showModal = !this.showModal;
    },
}
</script>