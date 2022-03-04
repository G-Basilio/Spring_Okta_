<template>
  <div id="profile">
    <div class="flex flex-col">
      <div class="-my-2 overflow-x-auto sm:-mx-6 lg:-mx-8">
        <div class="py-10 align-middle inline-block min-w-full sm:px-32 lg:px-7">
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
              class="bg-teal-lightest divide-y divide-black"
              v-for="(peoples, i) in people"
              :key="i"
            >
              <tr class="font-extrabold">
                <td class="px-3 py-4 whitespace-nowrap ">
                  <div class="flex items justify-center">
                      <div class="text-sm medium text-teal-darker">
                        {{ peoples.name }}
                    </div>
                  </div>
                </td>
                <td class="px-3 py-4 whitespace-nowrap">
                  <div class="flex items justify-center">
                      <div class="text-sm medium text-teal-darker">
                        {{ peoples.email }}
                    </div>
                  </div>
                </td>
                <td class="px-3 py-4 whitespace-nowrap">
                  <div class="flex items justify-center">
                    <div class="ml-4">
                      <div class="text-sm medium text-teal-darker">
                        {{ peoples.verificacao }}
                      </div>
                    </div>
                  </div>
                </td>
                <td class="px-3 py-4 whitespace-nowrap">
                  <div class="flex items justify-center">
                      <div class="text-sm medium text-teal-darker">
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
              <thead class="bg-teal-dark">
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
              class="bg-teal-lightest divide-y divide-black"
              v-for="(balances, i) in balance"
              :key="i"
            >
              <tr class="font-extrabold">
                <td class="px-3 py-4 whitespace-nowrap ">
                  <div class="flex items justify-center">
                      <div class="text-sm medium text-teal-darker">
                        {{ balances.simbolo }}
                    </div>
                  </div>
                </td>
                <td class="px-3 py-4 whitespace-nowrap">
                  <div class="flex items justify-center">
                      <div class="text-sm medium text-teal-darker">
                        {{ balances.nome }}
                    </div>
                  </div>
                </td>
                <td class="px-3 py-4 whitespace-nowrap">
                  <div class="flex items justify-center">
                    <div class="ml-4">
                      <div class="text-sm medium text-teal-darker">
                        {{ balances.volume }}
                      </div>
                    </div>
                  </div>
                </td>
                  <td class="px-3 py-4 whitespace-nowrap">
                  <div class="flex items justify-center">
                    <button
                      class="bg-teal-dark hover:bg-teal-darker text-white font-bold py-2 px-4 border border-black rounded"
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
    infosUser: []
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
  }
}
</script>
