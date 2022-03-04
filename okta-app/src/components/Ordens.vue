<!-- This example requires Tailwind CSS v2.0+ -->
<template>
  <div class="flex flex-col">
    <div class="-my-2 overflow-x-auto sm:-mx-6 lg:-mx-8">
      <div class="py-10 align-middle inline-block min-w-full sm:px-32 lg:px-7">
        <div class="shadow overflow-hidden border-b border-black sm:rounded-lg">
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
                Nome da ação
              </th>
              <th
                scope="col"
                class="px-6 py-3 text-center text-xs font- text-white uppercase tracking-wider"
              >
                Ask Min
              </th>
              <th
                scope="col"
                class="px-6 py-3 text-center text-xs font- text-white uppercase tracking-wider"
              >
                Ask Max
              </th>
              <th
                scope="col"
                class="px-6 py-3 text-center text-xs font- text-white uppercase tracking-wider"
              >
                Bid Min
              </th>
              <th
                scope="col"
                class="px-6 py-3 text-center text-xs font- text-white uppercase tracking-wider"
              >
                Bid Max
              </th>
              <th
                scope="col"
                class="px-6 py-3 text-center text-xs font- text-white uppercase tracking-wider"
              ></th>
            </thead>
            <tbody
              class="bg-teal-lightest divide-y divide-black"
              v-for="(acao, i) in acoes"
              :key="i"
            >
              <tr class="font-extrabold">       
                <td class="px-3 py-4 whitespace-nowrap">
                  <div class="flex items justify-center">
                    <div class="text-sm medium text-teal-darker">
                      {{ acao.simbol }}
                    </div>
                  </div>
                </td>
                <td class="px-3 py-4 whitespace-nowrap">
                  <div class="flex items justify-center">
                    <div class="text-sm medium text-teal-darker">
                      {{ acao.name }}
                    </div>
                  </div>
                </td>
                <td class="px-3 py-4 whitespace-nowrap">
                  <div class="flex items justify-center">
                    <div class="text-sm medium text-teal-darker">
                      {{ acao.askMin }}
                    </div>
                  </div>
                </td>
                <td class="px-3 py-4 whitespace-nowrap">
                  <div class="flex items justify-center">
                    <div class="text-sm medium text-teal-darker">
                      {{ acao.askMax }}
                    </div>
                  </div>
                </td>
                <td class="px-3 py-4 whitespace-nowrap">
                  <div class="flex items justify-center">
                    <div class="text-sm medium text-teal-darker">
                      {{ acao.bidMin }}
                    </div>
                  </div>
                </td>
                <td class="px-3 py-4 whitespace-nowrap">
                  <div class="flex items justify-center">
                    <div class="text-sm medium text-teal-darker">
                      {{ acao.bidMax }}
                    </div>
                  </div>
                </td>
                <td class="px-3 py-4 whitespace-nowrap">
                  <div class="flex items justify-center">
                    <button
                      class="bg-teal-dark hover:bg-teal-darker text-white font-bold py-2 px-4 border border-black rounded " type="button" data-modal-toggle="authentication-modal"
                    >
                      Comprar
                    </button>
                    <!-- <a href="#" class="text-grey-lighter font-bold py-1 px-3 rounded text-xs bg-green hover:bg-green-dark">Comprar</a> -->
                  </div>
                </td>
                <button class="block text-white bg-blue hover:bg-blue-lightest focus:ring-4 focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue dark:focus:ring-blue-lightest" type="button" data-modal-toggle="authentication-modal">
  Toggle modal
</button>

<!-- Main modal -->
<div id="authentication-modal" aria-hidden="true" class="hidden overflow-y-auto overflow-x-hidden fixed right-0 left-0 top-4 z-50 justify-center items-center h-modal md:h-full md:inset-0">
    <div class="relative px-4 w-full max-w-md h-full md:h-auto">
        <!-- Modal content -->
        <div class="relative bg-white rounded-lg shadow dark:bg-gray-700">
            <div class="flex justify-end p-2">
                <button type="button" class="text-white bg-transparent hover:bg-teal-dark hover:text-teal-dark rounded-lg text-sm p-1.5 ml-auto inline-flex items-center dark:hover:bg-gray-800 dark:hover:text-white" data-modal-toggle="authentication-modal">
                    <svg class="w-5 h-5" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" d="M4.293 4.293a1 1 0 011.414 0L10 8.586l4.293-4.293a1 1 0 111.414 1.414L11.414 10l4.293 4.293a1 1 0 01-1.414 1.414L10 11.414l-4.293 4.293a1 1 0 01-1.414-1.414L8.586 10 4.293 5.707a1 1 0 010-1.414z" clip-rule="evenodd"></path></svg>  
                </button>
            </div>
            <form class="px-6 pb-4 space-y-6 lg:px-8 sm:pb-6 xl:pb-8" action="#">
                <h3 class="text-xl font-medium text-teal-dark dark:text-white">Sign in to our platform</h3>
                <div>
                    <label for="email" class="block mb-2 text-sm font-medium text-teal-dark dark:text-gray-300">Your email</label>
                    <input type="email" name="email" id="email" class="bg-gray-50 border border-gray-300 text-teal-dark text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-white dark:text-white" placeholder="name@company.com" required>
                </div>
                <div>
                    <label for="password" class="block mb-2 text-sm font-medium text-teal-dark dark:text-gray-300">Your password</label>
                    <input type="password" name="password" id="password" placeholder="••••••••" class="bg-gray-50 border border-gray-300 text-teal-dark text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-white dark:text-white" required>
                </div>
                <div class="flex justify-between">
                    <div class="flex items-start">
                        <div class="flex items-center h-5">
                            <input id="remember" aria-describedby="remember" type="checkbox" class="w-4 h-4 bg-gray-50 rounded border border-gray-300 focus:ring-3 focus:ring-blue-300 dark:bg-gray-600 dark:border-gray-500 dark:focus:ring-blue-600 dark:ring-offset-gray-800" required>
                        </div>
                        <div class="ml-3 text-sm">
                        <label for="remember" class="font-medium text-teal-dark dark:text-gray-300">Remember me</label>
                        </div>
                    </div>
                    <a href="#" class="text-sm text-blue hover:underline dark:text-blue-500">Lost Password?</a>
                </div>
                <button type="submit" class="w-full text-white bg-blue hover:bg-blue-lightest focus:ring-4 focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue dark:focus:ring-blue-lightest">Login to your account</button>
                <div class="text-sm font-medium text-gray-500 dark:text-gray-300">
                    Not registered? <a href="#" class="text-blue hover:underline dark:text-blue-500">Create account</a>
                </div>
            </form>
        </div>
    </div>
</div> 
              </tr>
            </tbody>
          </table>
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
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data: () => ({
    acoes: [],
  }),
  created() {
    this.buscar();
  },
  methods: {

    async buscar() {
      if (this.$root.authenticated) {
        this.claims = await this.$auth.getUser();
        let accessToken = this.$auth.getAccessToken();
        console.log(`Authorization: Bearer ${accessToken}`);
        try {
          let response = await axios.get(`http://localhost:8083/stocks`, {
            headers: { Authorization: "Bearer " + accessToken },
          });
          console.log(response);

          for (var chave in response.data) {
            this.acoes.push({
              id: response.data[chave].id,
              simbol: response.data[chave].stock_symbol,
              name: response.data[chave].stock_name,
              askMin:
                response.data[chave].ask_min == null
                  ? 0
                  : response.data[chave].ask_min.toLocaleString("pt-BR", {
                      minimumFractionDigits: 2,
                    }),
              askMax:
                response.data[chave].ask_max == null
                  ? 0
                  : response.data[chave].ask_max.toLocaleString("pt-BR", {
                      minimumFractionDigits: 2,
                    }),
              bidMin:
                response.data[chave].bid_min == null
                  ? 0
                  : response.data[chave].bid_min.toLocaleString("pt-BR", {
                      minimumFractionDigits: 2,
                    }),
              bidMax:
                response.data[chave].bid_max == null
                  ? 0
                  : response.data[chave].bid_max.toLocaleString("pt-BR", {
                      minimumFractionDigits: 2,
                    }),
            });
          }
        } catch (error) {
          console.log("Ta errado isso aí");
          this.caffeineLevel = `${error}`;
        }
      }
    },
  },
};
</script>
