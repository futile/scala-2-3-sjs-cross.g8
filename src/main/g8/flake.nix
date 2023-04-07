{
  description = "Nix-flake to develop this project";

  inputs = {
    nixpkgs-stable.url = "github:nixos/nixpkgs/nixos-22.11";
    flake-utils.url = "github:numtide/flake-utils";
  };

  outputs = { self, nixpkgs-stable, flake-utils }:
    flake-utils.lib.eachDefaultSystem (system:
      let
        pkgs = nixpkgs-stable.legacyPackages.\${system};
        base-pkgs = with pkgs; [ sbt nodejs yarn ];
        human-pkgs = with pkgs; [ ];
      in {
        devShells = rec {
          base = pkgs.mkShellNoCC { nativeBuildInputs = base-pkgs; } // {
            name = "Base environment to build and run tests";
          };

          human-dev =
            pkgs.mkShellNoCC { nativeBuildInputs = (base-pkgs ++ human-pkgs); }
            // {
              # https://github.com/typelevel/sbt-tpolecat
              SBT_TPOLECAT_DEV=1;

              name =
                "Base environment with additional tools for human developers";
            };

          default = human-dev;
        };
      });
}
