<template>
  <div id="profile">
    <div class="flex-auto">
      <div class="-my-2 overflow-x-hidden sm:-mx-2 lg:-mx-1">
        <div
          class="py-20 align-middle inline-table min-w-full sm:px-32 lg:px-48"
        >
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
                class="divide-y divide-black"
                v-for="(peoples, i) in people"
                :key="i"
              >
                <tr class="font-extrabold">
                  <td class="px-3 py-4 whitespace-nowrap">
                    <div class="flex items justify-center">
                      <div class="text-gray-900">
                        {{ peoples.name }}
                      </div>
                    </div>
                  </td>
                  <td class="px-3 py-4 whitespace-nowrap">
                    <div class="flex items justify-center">
                      <div class="text-gray-900">
                        {{ peoples.email }}
                      </div>
                    </div>
                  </td>
                  <td class="px-3 py-4 whitespace-nowrap">
                    <div class="flex items justify-center">
                      <div class="text-gray-900">
                        {{ peoples.verificacao }}
                      </div>
                    </div>
                  </td>
                  <td class="px-3 py-4 whitespace-nowrap">
                    <div class="flex items justify-center">
                      <div class="text-gray-900">
                        {{ peoples.dinheiro }}
                      </div>
                    </div>
                  </td>
                </tr>
              </tbody>
            </table>
            <table class="min-w-full divide-y divide-black"></table>
            <th class="px-6 py-3 text-white"></th>
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
                
              >
                <tr class="font-extrabold" v-for="balances in balance"
                :key="balances">
                  <td class="px-3 py-4 whitespace-nowrap">
                    <div class="flex items justify-center">
                      <div class="text-gray-900">
                        {{ balances.simbolo }}
                      </div>
                    </div>
                  </td>
                  <td class="px-3 py-4 whitespace-nowrap">
                    <div class="flex items justify-center">
                      <div class="text-gray-900">
                        {{ balances.nome }}
                      </div>
                    </div>
                  </td>
                  <td class="px-3 py-4 whitespace-nowrap">
                    <div class="flex items justify-center">
                      <div class="ml-4">
                        <div class="text-gray-900">
                          {{ balances.volume }}
                        </div>
                      </div>
                    </div>
                  </td>
                  <td class="px-3 py-4 whitespace-nowrap">
                    <div class="flex items justify-center">
                      <button
                        @click="toggleModal()"
                        type="button"
                        class="bg-green-800 bg-opacity-80 hover:bg-yellow-400 text-white font-bold py-2 px-4 border-2 border-gray-800 rounded"
                      >
                        Vender
                      </button>
                    </div>
                  </td>
                  <div class="w-1/12">
                    <div
                      v-if="showModal"
                      class="overflow-x-hidden overflow-y-auto fixed inset-0 z-50 outline-none focus:outline-none justify-center items-center flex"
                    >
                      <div class="relative w-auto my-6 mx-auto max-w-6xl">
                        <!--content-->
                        <div
                          class="border-2 border-green-800 sm:rounded-lg shadow-lg relative flex flex-col w-full bg-green-200 bg-opacity-90 outline-none focus:outline-none"
                        >
                          <!--header-->
                          <div
                            class="flex items-start justify-center p-5 border-b border-solid border-black rounded-t"
                          >
                            <h5 class="text-3xl font-semibold">VENDER AÇÃO</h5>
                          </div>
                          <!--body-->
                          <form class="w-full max-w-lg p-10">
                            <div class="flex justify-evenly -mx-3 mb-2">
                              <div class="w-full md:w-1/3 px-3 mb-6 md:mb-0">
                                <label
                                  class="block uppercase tracking-widest text-gray-900 text-xs font-extrabold mb-2"
                                  for="grid-city"
                                >
                                  Quantidade
                                </label>
                                <input
                                  v-model="volume"
                                  class="appearance-none block w-4/5 bg-green-50 text-gray-900 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
                                  type="text"
                                />
                              </div>
                              <div class="w-full md:w-1/3 px-3 mb-6 md:mb-0">
                                <label
                                  class="block uppercase tracking-widest text-gray-700 text-xs font-extrabold mb-2"
                                  for="grid-zip"
                                >
                                  Preço
                                </label>
                                <input
                                  v-model="price"
                                  class="appearance-none block w-10/12 bg-green-50 text-gray-900 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
                                  type="text"
                                />
                              </div>
                            </div>
                          </form>
                          <!--footer-->
                          <div
                            class="flex items-center justify-evenly p-6 border-t border-solid border-black rounded-b"
                          >
                            <button
                              class="py-3 px-8 border border-transparent shadow-sm text-sm font-bold text-white bg-green-800 bg-opacity-80 rounded-md hover:bg-yellow-400 focus:outline-none"
                              @click="CreteOrdem"
                              v-on:click="toggleModal()"
                            >
                              Confirmar
                            </button>
                            <button
                              class="py-3 px-8 border border-transparent shadow-sm text-sm font-bold text-white bg-green-800 bg-opacity-80 rounded-md hover:bg-red-400 focus:outline-none"
                              type="button"
                              v-on:click="toggleModal(showModal)"
                            >
                              Cancelar
                            </button>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div
                      v-if="showModal"
                      class="opacity-25 fixed inset-0 z-40 bg-green-200"
                    ></div>
                  </div>
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
    teste: [],
    userId: "",
    stockName:"",
    acaoCompra: null,
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
          `http://localhost:8081/users/${this.claims.email}`,
          {
            headers: { Authorization: "Bearer " + accessToken },
          }
        );

        this.infosUser = response;
        console.log(response);

        this.people.push({
          name: this.claims.name,
          email: this.claims.email,
          verificacao: this.claims.email_verified,
          dinheiro: "R$ " + response.data.dollar_balance.toFixed(2),
          idUser: response.data.id,
        });
        console.log("aaaaaaaaaaaaaaaaaaa");

        console.log(this.name);
      }
    },
    async stockBalance() {
      if (this.$root.authenticated) {
        let accessToken = this.$auth.getAccessToken();
        let user = await this.$auth.getUser();

        try {
          let response = await axios.get(
            `http://localhost:8081/users/userId?email=${user.email}`,
            {
              headers: { Authorization: "Bearer " + accessToken },
            }
          );

          this.id_user = response.data;
          console.log("Aqui é oque pega do response");
          console.log(response);
        } catch (error) {
          this.stocks = `${error}`;
        }
        try {
          let response = await axios.get(
            `http://localhost:8081/stocks/teste/1`,
            {
              headers: { Authorization: "Bearer " + accessToken },
            }
          );

          console.log(response);
          for (var chave in response.data) {
            this.balance.push({
              simbolo: response.data[chave].stock_symbol,
              nome: response.data[chave].stock_name,
              volume: response.data[chave].volume,
            });
          }
        } catch (error) {
          this.stocks = `${error}`;
        }
      }
    },
  },
  toggleModal() {
    this.showModal = !this.showModal;
  },
};
</script>
