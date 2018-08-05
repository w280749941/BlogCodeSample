using System;
using System.Threading.Tasks;
using Grpc.Core;
using Grpcsharp;

namespace GrpcCsharpServer
{
    class Program
    {
        const int Port = 50051;

        public static async Task Main(string[] args)
        {
            Server server = new Server
            {
                Services = { Chat.BindService(new ChatImpl()) },
                Ports = { new ServerPort("localhost", Port, ServerCredentials.Insecure) }
            };
            server.Start();

            Console.WriteLine("Server is listening on port " + Port);
            Console.WriteLine("Press any key to stop the server...");
            Console.ReadKey();

            await server.ShutdownAsync();
        }
    }
}